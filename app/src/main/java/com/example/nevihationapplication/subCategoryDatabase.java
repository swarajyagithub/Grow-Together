package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class subCategoryDatabase extends SQLiteOpenHelper {
    public static final String databaseName = "subCategory";
    public static final String tableName = "subCategoryData";
    public static final String colS_1 = "ID";
    public static final String colS_2 = "SUBINFO";
    public static final String colS_3="NUM";

    public subCategoryDatabase( Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SUBINFO TEXT,NUM INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);

    }
    public void insertDataS( String sub, Integer num2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colS_2,sub );
        contentValues.put(colS_3, num2);
        db.insert(tableName, null, contentValues);

    }
    public Cursor getDataS()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cs=db.rawQuery("select * from "+tableName,null);
        return cs;
    }

}
