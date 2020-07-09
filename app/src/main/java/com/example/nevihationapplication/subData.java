package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class subData extends SQLiteOpenHelper {
    public static final String databaseName = "subDataInfo";
    public static final String tableName = "suUserData";
    public static final String col_1 = "ID";
    public static final String col_2 = " NAME";
    public static final String cal_3 = "NUMB";

    public static final String tableNameImage="ImageData";
    public static final String colI1="ID";
    public static final String colI2="NAMEI";
    public static final String colI3="IMAGE";

    public subData( Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMB INTEGER)");
        db.execSQL("create table " + tableNameImage + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAMEI TEXT,IMAGE BLOB)");


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameImage);
        onCreate(db);

    }


    public boolean insertDataS(String name, int numb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);
        contentValues.put(cal_3, numb);

        long result = db.insert(tableName, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getDataS()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableName,null);
        return res;
    }

    public boolean insertDataI(String nameI, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colI2, nameI);
        contentValues.put(colI3, image);

        long result = db.insert(tableNameImage, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getDataI()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameImage,null);
        return res;
    }

}
