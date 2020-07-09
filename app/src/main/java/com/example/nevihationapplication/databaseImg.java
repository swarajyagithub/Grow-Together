package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class databaseImg extends SQLiteOpenHelper {
    public static final String imageDatabaseName="ABC";
    public static final String tableNameImage="abc";
    public static final String colmn1="ID";
    public static final String colmn2="IMAGE";
    public databaseImg( Context context) {
        super(context, imageDatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameImage + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameImage);
        onCreate(db);


    }
    public boolean addEntry(byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentv = new ContentValues();
        contentv.put(colmn2,image);
        long result1=db.insert(tableNameImage,null,contentv);
        if (result1 == -1)
            return false;
        else
            return true;

    }
}
