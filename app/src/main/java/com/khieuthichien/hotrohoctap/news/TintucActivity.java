package com.khieuthichien.hotrohoctap.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khieuthichien.hotrohoctap.R;
import com.khieuthichien.hotrohoctap.adapter.NewspaperAdapter;
import com.khieuthichien.hotrohoctap.model.Newspaper;

import java.util.ArrayList;
import java.util.List;

public class TintucActivity extends AppCompatActivity {

    private RecyclerView lvListNewspaper;

    private NewspaperAdapter adapterNewspaper;
    private List<Newspaper> newspapers;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc);

        lvListNewspaper = findViewById(R.id.lvListNewspaper);
        // tao data

        newspapers = new ArrayList<>();
        Newspaper vietnamnet = new Newspaper("Tuyển sinh","https://vietnamnet.com","http://vietnamnet.vn/rss/home.rss");

        newspapers.add(vietnamnet);
        // khai bao

        adapterNewspaper = new NewspaperAdapter(this,newspapers);
        layoutManager = new LinearLayoutManager(this);
        lvListNewspaper.setAdapter(adapterNewspaper);
        lvListNewspaper.setLayoutManager(layoutManager);

    }
}
