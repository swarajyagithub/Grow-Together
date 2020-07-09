package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

public class imageTT extends SQLiteOpenHelper {
    public static final String databaseName="imageDatabase";
    public static final String tableName="imageCategory";
    public static final String cal_1="ID";
    public static final String cal_2="IMAGE";
    public static final String cal_3="NAME";
    public imageTT( Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB,NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);


    }
    public void insertData(byte[] image, String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cal_2,image);
        contentValues.put(cal_3,name);
        db.insert(tableName,null,contentValues);



    }


    public Cursor viewImage()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Bitmap bt=null;
        Cursor res=db.rawQuery("select * from "+tableName,null);

        return res;

    }

}
