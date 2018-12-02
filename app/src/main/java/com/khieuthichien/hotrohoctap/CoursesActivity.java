package com.khieuthichien.hotrohoctap;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.khieuthichien.hotrohoctap.adapter.SinhvienAdapter;
import com.khieuthichien.hotrohoctap.database.DatabaseHelper;
import com.khieuthichien.hotrohoctap.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    private List<Sinhvien> sinhvienList;
    private SinhvienAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        databaseHelper = new DatabaseHelper(this);

        recyclerview = findViewById(R.id.recyclerview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sinhvienList = new ArrayList<>();

        sinhvienList = databaseHelper.getAllSinhvien();

//        for (int i = 0; i < 1; i++) {
//            sinhvienList.add(new Sinhvien("ph06252", "Khieu dinh huu"));
//        }

        adapter = new SinhvienAdapter(this, sinhvienList, databaseHelper);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);


        FloatingActionButton fab = findViewById(R.id.fabthem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(CoursesActivity.this);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView = inflater.inflate(R.layout.dialog_add_sv, null);
                builder.setView(dialogView);
                final Dialog dialog = builder.show();

                final EditText edtmasv;
                final EditText edttensv;
                final Button btnadd;
                final Button btncancel;

                edtmasv = dialogView.findViewById(R.id.edtmasv);
                edttensv = dialogView.findViewById(R.id.edttensv);
                btnadd = dialogView.findViewById(R.id.btnadd);
                btncancel = dialogView.findViewById(R.id.btncancel);

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ma = edtmasv.getText().toString().trim();
                        String ten = edttensv.getText().toString().trim();

                        if (ma.equals("")){
                            edtmasv.setError(getString(R.string.notify_empty_name));
                            return;
                        }
                        if (ten.equals("")){
                            edttensv.setError(getString(R.string.notify_empty_name));
                            return;
                        }

                        Sinhvien sinhvien = new Sinhvien();
                        sinhvien.setMasv(ma);
                        sinhvien.setTensv(ten);

                        databaseHelper.insertSinhvien(sinhvien);
                        databaseHelper.getAllSinhvien();
                        Intent it = new Intent(CoursesActivity.this,CoursesActivity.class);
                        startActivity(it);

                        Toast.makeText(CoursesActivity.this, "đã thêm", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });


                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });



            }
        });



    }

    public void dangkikhoahoc() {
        startActivity(new Intent(getApplicationContext(), DangkikhoahocActivity.class));
    }




}
