package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class singleDatabase extends SQLiteOpenHelper {
    public static final String databaseName1 = "UserInformationDatabase";
    public static final String tableNameU = "UserData";
    public static final String col_1 = "ID";
    public static final String col_2 = " NAME";
    public static final String cal_3 = "SURNAME";
    public static final String cal_4 = "EMAIL";
    public static final String cal_5 = "PASSWORD";

    public static final String tableNameC = "Category";
    public static final String col_1C = "ID";
    public static final String col_2C= " NAME";
    public static final String col_3C = "IMAGE";

    public static final String tableNameS = "suUserData";
    public static final String col_1S = "ID";
    public static final String col_2S = " NAME";
    public static final String cal_3S = "NUMB";

//Agriculture and Farming
    public static final String tableNameA = "agriData";
    public static final String col_1A = "ID";
    public static final String col_2A = " NAME";
    public static final String col_3A = "NUMB";

    public static final String tableNameB = "birdsData";
    public static final String col_1B = "ID";
    public static final String col_2B = " NAME1";
    public static final String col_3B = "NAME2";
    public static final String col_4B = "NAME3";
    public static final String col_5B = " NAME4";
    public static final String col_6B = "IMAGE";




    public singleDatabase( Context context) {

        super(context, databaseName1, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameU + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("create table " + tableNameC + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,IMAGE INTEGER)");
        db.execSQL("create table " + tableNameS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMB INTEGER)");
        db.execSQL("create table " + tableNameA + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMB INTEGER)");
        db.execSQL("create table " + tableNameB + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME1 TEXT,NAME2 TEXT,NAME3 TEXT,NAME4 TEXT,IMAGE INTEGER)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameU);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameC);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameS);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameA);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameB);


        onCreate(db);


    }


    public boolean insertUserData(String name, String surname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);
        contentValues.put(cal_3, surname);
        contentValues.put(cal_4, email);
        contentValues.put(cal_5, password);
        long result = db.insert(tableNameU, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public  boolean isLogin(String mail,String pass)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String sql=  "Select * from'"+tableNameU+"'where EMAIL='"+mail+"'and PASSWORD='"+pass+"'";
        Cursor c=db.rawQuery(sql,null) ;
        if(c.getCount()>0)

            return false;
        else
            return true;
    }
    public boolean checkMail(String EMAIL) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+tableNameU+" where EMAIL=?", new String[]{EMAIL});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;

    }
    public Cursor getFirstName(String EMAIL)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursorF=db.rawQuery("Select * from "+tableNameU+" where EMAIL=?",new String[]{EMAIL});
        return cursorF;
    }

    public boolean addCategory(String name,int img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2C,name);
        contentValues.put(col_3C,img);
        long result=db.insert(tableNameC,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public boolean insertDataS(String name, int numb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2S, name);
        contentValues.put(cal_3S, numb);

        long result = db.insert(tableNameS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getDataS()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameS,null);
        return res;
    }
    public Cursor getCategory()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from "+tableNameC,null);

        return cursor;

    }
    public void removeCategory(String NAME)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete  from "+tableNameC+" where NAME=?",new String[]{NAME});
    }

    public void removeSubCatData(String NAME)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete from "+tableNameS+" where NAME=?",new String[]{NAME});
    }


    public void removeAgriData(String NAME)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete from "+tableNameA+" where NAME=?",new String[]{NAME});
    }

//insert data(agriculture) into agriData table
    public boolean insertDataAgri(String name, int numb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2A, name);
        contentValues.put(col_3A, numb);

        long result = db.insert(tableNameA, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }



    public Cursor getDataAgri()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameA,null);
        return res;
    }

    public boolean insertDataB(String name1, String name2, String name3, String nmae4, int img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2B, name1);
        contentValues.put(col_3B, name2);
        contentValues.put(col_4B, name3);
        contentValues.put(col_5B, nmae4);
        contentValues.put(col_6B,img);

        long result = db.insert(tableNameB, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getDataBrd()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameB,null);
        return res;
    }

    public void removeBirdData(String NAME)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete from "+tableNameB+" where NAME1=?",new String[]{NAME});
    }
}
