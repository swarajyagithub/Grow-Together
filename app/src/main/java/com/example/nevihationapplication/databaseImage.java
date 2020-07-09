package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

public class databaseImage extends SQLiteOpenHelper {
    public static final String databaseNameI="imageData";
    public static final String tableNameI="image";
    public static final String c1="ID";
    public static final String c2="IMAGE";
    public databaseImage( Context context) {
        super(context, databaseNameI, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameI + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameI);
        onCreate(db);

    }

    public boolean addImage(byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(c2,image);
        long result=db.insert(tableNameI,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor viewImage()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from "+tableNameI,null);

        return cursor;

    }
}
