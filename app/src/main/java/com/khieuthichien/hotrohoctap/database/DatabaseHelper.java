package com.khieuthichien.hotrohoctap.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.khieuthichien.hotrohoctap.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABSE_NAME = "sv_db";
    public static final int DATABSE_VERSION = 1;

    public static final String TABLE_SINHVIEN = "sinhvien";

    public static final String COLUMN_MA_SINHVIEN = "masv";
    public static final String COLUMN_TEN_SINHVIEN = "tensv";

    public DatabaseHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_SINHVIEN + "(" +
                "" + COLUMN_MA_SINHVIEN + " NVARCHAR PRIMARY KEY NOT NULL, " +
                "" + COLUMN_TEN_SINHVIEN + " NVARCHAR NOT NULL " +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_SINHVIEN );
        onCreate(db);
    }

    public void insertSinhvien(Sinhvien sinhvien){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_MA_SINHVIEN, sinhvien.getMasv());
        values.put(COLUMN_TEN_SINHVIEN, sinhvien.getTensv());

        db.insert(TABLE_SINHVIEN, null, values);
        db.close();
    }

    public Sinhvien getSinhvien(String sinhvien){
        Sinhvien sinhvien1 = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SINHVIEN,
                new String[]{COLUMN_MA_SINHVIEN, COLUMN_TEN_SINHVIEN},
                COLUMN_MA_SINHVIEN + " =? ",
                new String[]{String.valueOf(sinhvien)},
                null, null, null );

        if (cursor != null && cursor.moveToFirst()){
            sinhvien1 = new Sinhvien(cursor.getString(0), cursor.getString(1));
        }

        cursor.close();
        return sinhvien1;

    }

    public List<Sinhvien> getAllSinhvien(){
        List<Sinhvien> sinhvienList = new ArrayList<>();

        String selectQuery = " SELECT * FROM " + TABLE_SINHVIEN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Sinhvien sinhvien = new Sinhvien();
                sinhvien.setMasv(cursor.getString(0));
                sinhvien.setTensv(cursor.getString(1));
            }while (cursor.moveToNext());
        }

        db.close();

        return sinhvienList;
    }

    public void updateSinhvien(Sinhvien sinhvien){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN_SINHVIEN, sinhvien.getTensv());

        db.update(TABLE_SINHVIEN , values, COLUMN_MA_SINHVIEN + "=?", new String[]{String.valueOf(sinhvien.getMasv())});
        db.close();
    }

    public void deleteSinhvien(String sinhvienid){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_SINHVIEN, COLUMN_MA_SINHVIEN + "=?", new String[]{String.valueOf(sinhvienid)});
        db.close();
    }


}
