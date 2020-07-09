package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class arrayListImage extends SQLiteOpenHelper {
    public static final String databaseName="imageDatabase";
    public static final String tableName="imageCategory";
    public static final String cal1img="ID";
    public static final String cal2img="IMAGE";
    ArrayList<Bitmap> imgBitmap=new ArrayList<Bitmap>();
    public arrayListImage( Context context) {

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
    public boolean insertDataImg(byte[] image)
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
    public ArrayList<Bitmap> viewImage()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Bitmap bt=null;
        Cursor res=db.rawQuery("select * from "+tableName,null);
        if(res.moveToNext())
        {
            byte[] img=res.getBlob(1);
            bt= BitmapFactory.decodeByteArray(img,0,img.length);
            imgBitmap.add(bt);
        }
        return imgBitmap;
    }
}
