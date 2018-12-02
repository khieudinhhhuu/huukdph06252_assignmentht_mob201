package com.khieuthichien.hotrohoctap.news;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.khieuthichien.hotrohoctap.R;
import com.khieuthichien.hotrohoctap.adapter.NewsAdapter;
import com.khieuthichien.hotrohoctap.model.News;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView lvListNews;
    private NewsAdapter adapterNews;
    private LinearLayoutManager layoutManager;
    private List<News> news;

    private String rssLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        lvListNews = findViewById(R.id.lvListNews);
        rssLink = getIntent().getStringExtra("data");

        LoadRssFromInternetTask loadRssFromInternetTask = new LoadRssFromInternetTask(this);
        loadRssFromInternetTask.execute(rssLink);

    }

    class LoadRssFromInternetTask extends AsyncTask<String, Long, List<News>> {

        private Context context;

        public LoadRssFromInternetTask(Context context) {
            this.context = context;
            Log.e("START", "START");

        }

        // ham xu ly ngam
        @Override
        protected List<News> doInBackground(String... strings) {

            ArrayList<News> newsArrayList = new ArrayList<>();

            try {
                URL url = new URL(strings[0]);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();

                // We will get the XML from an input stream
                xpp.setInput(getInputStream(url), "UTF_8");

                int eventType = xpp.getEventType();
                String text = "";

                News news = null;
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String nameTag = xpp.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:

                            Log.e("Name", xpp.getName());
                            if (nameTag.equalsIgnoreCase("item")) {
                                news = new News();
                                Log.e("CREATE", "NEWS");
                            }
                            break;

                        case XmlPullParser.TEXT:
                            text = xpp.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            if (nameTag.equals("item"))
                                newsArrayList.add(news);
                            else if (news != null & nameTag.equalsIgnoreCase("title"))
                                news.title = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("description"))
                                news.description = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("pubDate"))
                                news.pubDate = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("link"))
                                news.link = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("image"))
                                news.image = text.trim();


                            Log.e("END_TAG " + nameTag, text + "");
                            break;

                        default:
                            break;

                    }
                    eventType = xpp.next(); //move to next element
                }

                Log.e("SIZE", newsArrayList.size() + "");


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newsArrayList;
        }

        private InputStream getInputStream(URL url) {
            try {
                return url.openConnection().getInputStream();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);

            adapterNews = new NewsAdapter(context, news);
            layoutManager = new LinearLayoutManager(context);

            lvListNews.setLayoutManager(layoutManager);
            lvListNews.setAdapter(adapterNews);

        }

    }


}
