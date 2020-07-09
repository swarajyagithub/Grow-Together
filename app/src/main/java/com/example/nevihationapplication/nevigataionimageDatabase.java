package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class nevigataionimageDatabase extends SQLiteOpenHelper {
    public static final String databaseName="imageData";
    public static final String tableName="imageCate";
    public static final String cal1img="ID";
    public static final String cal2img="IMAGE";
    public nevigataionimageDatabase( Context context) {
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
    public boolean insertImg(byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cal2img,image);
        long result=db.insert(tableName,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
}
