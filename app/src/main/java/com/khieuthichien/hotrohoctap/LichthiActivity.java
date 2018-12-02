package com.khieuthichien.hotrohoctap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LichthiActivity extends AppCompatActivity {

    private ListView lvlichthi;
    String[] arr = new String[]{"Buổi số: 1\n Ngày thi: 03-11-2018\n Phòng thi: H203 \nCa thi: ca 2",
            "Buổi số: 2\n Ngày thi: 05-11-2018\n Phòng thi: H203 \nCa thi: ca 2",
            "Buổi số: 3\n Ngày thi: 07-11-2018\n Phòng thi: H203 \nCa thi: ca 2",
            "Lưu ý: Sinh viên đến trước 15 phút"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichthi);
        lvlichthi = findViewById(R.id.lvlichthi);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LichthiActivity.this, android.R.layout.simple_list_item_1, arr);

        lvlichthi.setAdapter(adapter);

    }
}
