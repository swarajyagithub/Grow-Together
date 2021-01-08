package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class photoDatabase extends SQLiteOpenHelper {
    public static final String databaseNameI="imageDataI";
    public static final String tableNameI="image";
    public static final String c1="ID";
    public static final String c2="IMAGE";
    public static final String c3="NAME";
    public photoDatabase( Context context) {
        super(context, databaseNameI, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameI + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB,NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameI);
        onCreate(db);
    }
    public boolean addImage(byte[] image,String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(c2,image);
        contentValues.put(c3,name);
        long result=db.insert(tableNameI,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor getImage()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursorF=db.rawQuery("Select * from "+tableNameI,null);
       return cursorF;
    }
}
