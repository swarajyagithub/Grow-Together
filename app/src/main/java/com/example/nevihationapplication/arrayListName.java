package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class arrayListName extends SQLiteOpenHelper {
    public static final String databaseName = "userInfo";
    public static final String tableName = "UserDataI";
    public static final String col_1 = "ID";
    public static final String col_2 = " NAME";
    public static final String col_3="IMAGE";
    public arrayListName(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,IMAGE BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }
    public boolean insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);

        long result = db.insert(tableName, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertImage(byte[] img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_3, img);

        long result = db.insert(tableName, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+tableName,null);
        return res;
    }
    public Cursor getImage()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res1=db.rawQuery("select * from "+tableName,null);
        return res1;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+tableName,null);
        return res;
    }
}
