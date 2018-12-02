package com.khieuthichien.hotrohoctap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LichhocActivity extends AppCompatActivity {

    private ListView lvlichhoc;
    String[] arr = new String[] {"Ca 2 Phòng H203\n 18-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 18-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 20-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 22-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 24-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 26-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 28-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 30-10-2018\n Giảng viên: Huy Nguyễn",
            "Ca 2 Phòng H203\n 01-11-2018\n Giảng viên: Huy Nguyễn"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichhoc);
        lvlichhoc = findViewById(R.id.lvlichhoc);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LichhocActivity.this, android.R.layout.simple_list_item_1, arr);

        lvlichhoc.setAdapter(adapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lichthi, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //xay dung phuong thuc de bat su kien nguoi dung click vao 1 item nao do
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_lichthi:
                startActivity(new Intent(getApplicationContext(), LichthiActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
