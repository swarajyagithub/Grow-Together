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

public class databaseImage extends SQLiteOpenHelper {
    public static final String databaseNameI="imageData";
    public static final String tableNameI="image";
    public static final String c1="ID";
    public static final String c2="IMAGE";

    public static final String tableNameS="imageString";
    public static final String cs1="ID";
    public static final String cs2="IMAGE";
    public databaseImage( Context context) {
        super(context, databaseNameI, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameI + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB )");
        db.execSQL("create table " + tableNameS+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameI);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameS);
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
    public boolean addImage(String simg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cs2,simg);
        long result=db.insert(tableNameS,null,contentValues);
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
    public ArrayList<Bitmap> getImage()
    {
        SQLiteDatabase db=this.getWritableDatabase();
       Bitmap bt;
        //String sql=  "Select * from'"+tableNameI+"'where EMAIL='"+mail+"'and PASSWORD='"+pass+"'";
        ArrayList<Bitmap> araybit=new ArrayList<Bitmap>();
        Cursor crs=db.rawQuery("Select * from "+tableNameI,null);
        crs.moveToNext();
        while (!crs.isAfterLast())
        {


            byte[] image=crs.getBlob(1);
            bt=BitmapFactory.decodeByteArray(image,0,image.length);
            araybit.add(bt);
            crs.moveToNext();
        }
        return araybit;
    }
    public void addImageUrl(String url)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cs2,url);
        long result=db.insert(tableNameS,null,contentValues);

    }
}
