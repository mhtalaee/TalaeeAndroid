package com.example.talaeeandroid.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenDBHelper extends SQLiteOpenHelper {

    String TABLE_NAME = "tblTimings";
    String create_db_query =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "city_name TEXT," +
                    "fajr TEXT," +
                    "sunrise TEXT," +
                    "dhuhr TEXT," +
                    "asr TEXT," +
                    "sunset TEXT," +
                    "maghrib TEXT," +
                    "isha TEXT," +
                    "imsak TEXT," +
                    "midnight TEXT" +
                    ")";

    public OpenDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_db_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserToDB(String cityName, String fajr, String sunrise) {
        String insertQuery = "INSERT INTO " + TABLE_NAME +
                "(city_name , fajr)" +
                "VALUES( '" + cityName + "' , '" + fajr + " ')";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
        db.close();
    }

    public String getTimings() {
        String test = "";
        SQLiteDatabase db = this. getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT city_name, fajr from " + TABLE_NAME, null);
        while (cursor.moveToNext()) {
            test += cursor.getString(0)+"\n" + cursor.getString(1)+"\n";
        }
        db.close();
        return test;
    }

}
