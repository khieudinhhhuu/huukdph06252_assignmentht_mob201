package com.khieuthichien.hotrohoctap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.khieuthichien.hotrohoctap.news.TintucActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgcourse;
    private ImageView imgmaps;
    private ImageView imgnews;
    private ImageView imgsocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initActions();

    }

    private void initActions() {
        imgmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });

        imgnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TintucActivity.class));
            }
        });

        imgcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CoursesActivity.class));
            }
        });

        imgsocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShareActivity.class));
            }
        });
    }

    private void initViews() {
        imgcourse = findViewById(R.id.imgcourse);
        imgmaps = findViewById(R.id.imgmaps);
        imgnews = findViewById(R.id.imgnews);
        imgsocial = findViewById(R.id.imgsocial);
    }

}
