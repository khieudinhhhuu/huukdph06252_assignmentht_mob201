package com.khieuthichien.hotrohoctap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MonhocActivity extends AppCompatActivity {

    private ListView lvmonhoc;
    String[] arr = new String[] {"Lập trình Android cơ bản\n Số tín chỉ: 17",
            "Thiết kế giao diện\n Số tín chỉ: 17",
            "Lập trình Android nâng cao\n Số tín chỉ: 17",
            "Dự án mẫu Android\n Số tín chỉ: 17",
            "Dự án 1 Android\n Số tín chỉ: 17",
            "Android Net Working\n Số tín chỉ: 17",
            "Game 2D\n Số tín chỉ: 17",
            "Test Android\n Số tín chỉ: 17",
            "Dự án cuối môn\n Số tín chỉ: 17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monhoc);
        lvmonhoc = findViewById(R.id.lvmonhoc);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MonhocActivity.this, android.R.layout.simple_list_item_1, arr);

        lvmonhoc.setAdapter(adapter);

        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MonhocActivity.this, LichhocActivity.class);
                intent.putExtra("monhoc", arr[i] );
                startActivity(intent);
            }
        });

    }
}
