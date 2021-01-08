package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class imageURLData2 extends SQLiteOpenHelper {
    public static final String databaseNameI="imageInt";
    public static final String tableNameI="imageI";
    public static final String c1="ID";
    public static final String c2="IMAGE";
    public imageURLData2( Context context) {
        super(context, databaseNameI, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameI+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameI);
        onCreate(db);

    }

    //code for inserting data
    public boolean addImage(int img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(c2,img);
        long result=db.insert(tableNameI,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    //code for retrieving data
    public Cursor viewImageS()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from "+tableNameI,null);

        return cursor;

    }
}
