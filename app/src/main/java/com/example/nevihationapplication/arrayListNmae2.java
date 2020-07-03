package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

public class arrayListNmae2 extends SQLiteOpenHelper {
    public static final String databaseName = "categoryImage";
    public static final String tableName = "imageInformation";
    public static final String col_1 = "ID";
    public static final String col_2 = " IMAGE";
    public arrayListNmae2( Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);

    }
    public void insertImage(byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,image);

        db.insert(tableName,null,contentValues);

    }

    public Cursor getImage()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+tableName,null);
        return res;
    }



}
