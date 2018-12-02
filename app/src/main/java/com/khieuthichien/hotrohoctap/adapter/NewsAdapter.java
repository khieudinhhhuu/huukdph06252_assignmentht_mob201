package com.khieuthichien.hotrohoctap.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khieuthichien.hotrohoctap.news.NewsDetailActivity;
import com.khieuthichien.hotrohoctap.R;
import com.khieuthichien.hotrohoctap.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private List<News> news;

    public NewsAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsHolder holder, int position) {
        final News itemNews = news.get(position);
        holder.tvTitle.setText(itemNews.title);
        holder.tvDate.setText(itemNews.pubDate);
        holder.tvDes.setText(itemNews.description);


        // load image to ImageView by Glide library
        Glide.with(context).load(itemNews.image).into(holder.imgThumbs);

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("link", itemNews.link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (news == null) return 0;
        return news.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        public final ImageView imgThumbs;
        public final TextView tvTitle;
        public final TextView tvDes;
        public final TextView tvDate;

        public NewsHolder(View itemView) {
            super(itemView);

            imgThumbs = itemView.findViewById(R.id.imgThumbs);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}
