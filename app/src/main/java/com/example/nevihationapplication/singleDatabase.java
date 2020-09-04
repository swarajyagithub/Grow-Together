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


//Company info:
    public static final String tableNameCom = "companyInfo";
    public static final String col_1Com = "ID";
    public static final String col_2Com = " NAME";
    public static final String col_3Com = "CEO";
    public static final String col_4Com = "ADDRESS";
    public static final String col_5Com = " COUNTRY";
    public static final String col_6Com = "STATE";
    public static final String col_7Com = "DISTRICT";
    public static final String col_8Com = " CITY";
    public static final String col_9Com = "PINCODE";
    public static final String col_10Com = "EMAIL1";
    public static final String col_11Com = " EMAIL2";
    public static final String col_12Com = "MOBILE";
    public static final String col_13Com = " TEL";
    public static final String col_14Com = "FAX";
    public static final String col_15Com = "WEB";
    public static final String col_16Com = " GMAP";
    public static final String col_17Com = "KEYW";

    //Company info1:
    public static final String tableNameCom1 = "companyInfo";
    public static final String col_1Com1 = "ID";
    public static final String col_2Com1 = " NAME";
    public static final String col_3Com1 = "CEO";
    public static final String col_4Com1 = "ADDRESS";
    public static final String col_5Com1 = " COUNTRY";
    public static final String col_6Com1 = "STATE";
    public static final String col_7Com1 = "DISTRICT";
    public static final String col_8Com1 = " CITY";
    public static final String col_9Com1 = "PINCODE";
    public static final String col_10Com1 = "EMAIL1";
    public static final String col_11Com1 = " EMAIL2";
    public static final String col_12Com1 = "MOBILE";
    public static final String col_13Com1 = " TEL";
    public static final String col_14Com1 = "FAX";
    public static final String col_15Com1 = "WEB";
    public static final String col_16Com1 = " GMAP";
    public static final String col_17Com1 = "KEYW";


    public static final String tableNameCom2 = "companyInfo2";
    public static final String col_1Com2 = "ID";
    public static final String col_2Com2 = " NAME";
    public static final String col_3Com2 = "CEO";
    public static final String col_4Com2 = "ADDRESS";
    public static final String col_5Com2 = " COUNTRY";
    public static final String col_6Com2 = "STATE";
    public static final String col_7Com2 = "DISTRICT";
    public static final String col_8Com2 = " CITY";
    public static final String col_9Com2 = "PINCODE";
    public static final String col_10Com2 = "EMAIL1";
    public static final String col_11Com2 = " EMAIL2";
    public static final String col_12Com2 = "MOBILE";
    public static final String col_13Com2 = " TEL";
    public static final String col_14Com2 = "FAX";
    public static final String col_15Com2 = "WEB";
    public static final String col_16Com2 = " GMAP";
    public static final String col_17Com2= "KEYW";


    //Company Social Info:
    public static final String tableNameComS = "companyInfoS";
    public static final String col_1ComS = "ID";
    public static final String col_2ComS = " NAME";
    public static final String col_3ComS = "TEL";
    public static final String col_4ComS = "EMAIL";
    public static final String col_5ComS = " FACEBOOK";
    public static final String col_6ComS = "TWITTER";
    public static final String col_7ComS = "LINKEDIN";

//Product and Services:
    public static final String tableNameProduct = "Product";
    public static final String col_1Pr = "ID";
    public static final String col_2Pr = "NAME";
    public static final String col_3Pr = " CAT";
    public static final String col_4Pr = "SUBCAT";
    public static final String col_5Pr = "CURRENCY";
    public static final String col_6Pr = " PRIZE";
    public static final String col_7Pr = "DISPRIZ";
    public static final String col_8Pr = "IMAGE";
    public static final String col_9Pr = " DISCP";
    public static final String col_10Pr = "KEYW";

//CAREER INFO:
    public static final String tableNameCareer = "Career";
    public static final String col_1Cr = "ID";
    public static final String col_2Cr = "NAME";
    public static final String col_3Cr = " LOCATION";
    public static final String col_4Cr = "PACK";
    public static final String col_5Cr = "POSITION";
    public static final String col_6Cr = " COMP";
    public static final String col_7Cr = "WORKEXP";
    public static final String col_8Cr = "EDUCATION";
    public static final String col_9Cr = " JOBCATEGORY";
    public static final String col_10Cr = "DESCRIPTION";

    public static final String tableNameCareer12 = "Career12";
    public static final String col_1Cr1 = "ID";
    public static final String col_2Cr1 = "NAME";
    public static final String col_3Cr1 = " LOCATION";
    public static final String col_4Cr1 = "PACK";
    public static final String col_5Cr1 = "POSITION";
    public static final String col_6Cr1 = " COMP";
    public static final String col_7Cr1 = "WORKEXP";
    public static final String col_8Cr1 = "EDUCATIN";
    public static final String col_9Cr1 = " JOBCATEGORY";
    public static final String col_10Cr1 = "DESCRIPTION";

//Enquiry:
    public static final String tableNameEn = "Enquiry";
    public static final String col_1En = "ID";
    public static final String col_2En = "ENQUIRY";
    public static final String col_3En = " NAME";
    public static final String col_4En = "MOBILE";
    public static final String col_5En = "EMAIL";

//General Enquity:
    public static final String tableNameGn = "GeneralEn";
    public static final String col_1Gn = "ID";
    public static final String col_2Gn = "ENQUIRY";
    public static final String col_3Gn = " NAME";
    public static final String col_4Gn = "MOBILE";
    public static final String col_5Gn = "EMAIL";

//Referal
    public static final String tableNameR = "Referal";
    public static final String col_1Rr = "ID";
    public static final String col_2Rr = "NAME";
    public static final String col_3Rr = " PHONE";
    public static final String col_4Rr = "EMAIL";
    public static final String col_5Rr = "ADDRESS";
    public static final String col_6Rr = " COMENT";

    public singleDatabase(Context context) {

        super(context, databaseName1, null, 7);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameU + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("create table " + tableNameC + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,IMAGE INTEGER)");
        db.execSQL("create table " + tableNameS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMB INTEGER)");
        db.execSQL("create table " + tableNameA + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMB INTEGER)");
        db.execSQL("create table " + tableNameB + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME1 TEXT,NAME2 TEXT,NAME3 TEXT,NAME4 TEXT,IMAGE INTEGER)");
        //db.execSQL("create table " + tableNameCom + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CEO TEXT,ADDRESS TEXT,COUNTRY TEXT,STATE TEXT,DISTRICT TEXT,PINCODE INTEGER,EMAIL1 TEXT,EMAIL2 TEXT,MOBILE INTEGER,TEL INTEGER,FAX TEXT,GMAP TEXT,KEYW TEXT)");
       // db.execSQL("create table " + tableNameCom1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CEO TEXT,ADDRESS TEXT,COUNTRY TEXT,STATE TEXT,DISTRICT TEXT,PINCODE TEXT,EMAIL1 TEXT,EMAIL2 TEXT,MOBILE TEXT,TEL TEXT,FAX TEXT,GMAP TEXT,KEYW TEXT)");
        db.execSQL("create table " + tableNameCom2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CEO TEXT,ADDRESS TEXT,COUNTRY TEXT,STATE TEXT,DISTRICT TEXT,CITY TEXT,PINCODE TEXT,EMAIL1 TEXT,EMAIL2 TEXT,MOBILE TEXT,TEL TEXT,FAX TEXT,WEB TEXT,GMAP TEXT,KEYW TEXT)");
        db.execSQL("create table " + tableNameComS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,TEL INTEGER,EMAIL TEXT,FACEBOOK TEXT,TWITTER TEXT,LINKEDIN TEXT)");
        db.execSQL("create table " + tableNameProduct + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CAT TEXT,SUBCAT TEXT,CURRENCY TEXT,PRIZE TEXT,DISPRIZ TEXT,IMAGE INTEGER,DISCP TEXT,KEYW TEXT)");
        //db.execSQL("create table " + tableNameCareer + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,LOCATION TEXT,PACK TEXT,POSITION TEXT,COMP TEXT,WORKEXP TEXT,EDUCATIN TEXT,JOBCATEGORY TEXT,DESCRIPTION TEXT)");
        db.execSQL("create table " + tableNameCareer12 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,LOCATION TEXT,PACK TEXT,POSITION TEXT,COMP TEXT,WORKEXP TEXT,EDUCATIN TEXT,JOBCATEGORY TEXT,DESCRIPTION TEXT)");
        db.execSQL("create table " + tableNameEn + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ENQUIRY TEXT,NAME TEXT,MOBILE INTEGER,EMAIL TEXT)");
        db.execSQL("create table " + tableNameGn + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ENQUIRY TEXT,NAME TEXT,MOBILE INTEGER,EMAIL TEXT)");
        db.execSQL("create table " + tableNameR + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE INTEGER,EMAIL TEXT,ADDRESS TEXT,COMENT TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameU);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameC);
        db.execSQL("DROP TABLE IF EXISTS " + tableNameS);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameA);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameB);
       // db.execSQL("DROP TABLE IF EXISTS " +tableNameCom);
       // db.execSQL("DROP TABLE IF EXISTS " +tableNameCom1);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameCom2);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameComS);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameProduct);
        //db.execSQL("DROP TABLE IF EXISTS " +tableNameCareer);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameCareer12);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameEn);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameGn);
        db.execSQL("DROP TABLE IF EXISTS " +tableNameR);


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

    public boolean insertDataDialog(String Enquiry, String Name, int Mobile, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2En, Enquiry);
        contentValues.put(col_3En, Name);
        contentValues.put(col_4En, Mobile);
        contentValues.put(col_5En, email);

        long result = db.insert(tableNameEn, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getDataEnquiry()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameS,null);
        return res;
    }

    public boolean insertDataCompany(String name1, String name2, String address, String country, String state,String dist,String city, int pincode,String email,String emailr,int mobile,int tel,String fax, String web, String gmap, String k) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2Com, name1);
        contentValues.put(col_3Com, name2);
        contentValues.put(col_4Com, address);
        contentValues.put(col_5Com, country);
        contentValues.put(col_6Com,state);
        contentValues.put(col_7Com,dist);
        contentValues.put(col_8Com,city);
        contentValues.put(col_9Com,pincode);
        contentValues.put(col_10Com,email);
        contentValues.put(col_11Com,emailr);
        contentValues.put(col_12Com,mobile);
        contentValues.put(col_13Com,tel);
        contentValues.put(col_14Com,fax);
        contentValues.put(col_15Com,web);
        contentValues.put(col_16Com,gmap);
        contentValues.put(col_17Com,k);



        long result = db.insert(tableNameCom, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataCompany2(String name1, String name2, String address, String country, String state,String dist,String city, String pincode,String email,String emailr,String mobile,String tel,String fax, String web, String gmap, String k) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2Com1, name1);
        contentValues.put(col_3Com1, name2);
        contentValues.put(col_4Com1, address);
        contentValues.put(col_5Com1, country);
        contentValues.put(col_6Com1,state);
        contentValues.put(col_7Com1,dist);
        contentValues.put(col_8Com1,city);
        contentValues.put(col_9Com1,pincode);
        contentValues.put(col_10Com1,email);
        contentValues.put(col_11Com1,emailr);
        contentValues.put(col_12Com1,mobile);
        contentValues.put(col_13Com1,tel);
        contentValues.put(col_14Com1,fax);
        contentValues.put(col_15Com1,web);
        contentValues.put(col_16Com1,gmap);
        contentValues.put(col_17Com1,k);



        long result = db.insert(tableNameCom2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getDataCompany()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameCom2,null);
        return res;
    }

    public void removeCompanyData(String NAME)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete from "+tableNameCom2+" where COUNTRY=?",new String[]{NAME});
    }

    public boolean updateCompanyData(String name1, String name2, String address, String country, String state,String dist,String city, String pincode,String email,String emailr,String mobile,String tel,String fax, String web, String gmap, String k) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2Com1, name1);
        contentValues.put(col_3Com1, name2);
        contentValues.put(col_4Com1, address);
        contentValues.put(col_5Com1, country);
        contentValues.put(col_6Com1, state);
        contentValues.put(col_7Com1, dist);
        contentValues.put(col_8Com1, city);
        contentValues.put(col_9Com1, pincode);
        contentValues.put(col_10Com1, email);
        contentValues.put(col_11Com1, emailr);
        contentValues.put(col_12Com1, mobile);
        contentValues.put(col_13Com1, tel);
        contentValues.put(col_14Com1, fax);
        contentValues.put(col_15Com1, web);
        contentValues.put(col_16Com1, gmap);
        contentValues.put(col_17Com1, k);

        db.update(tableNameCom2,contentValues,"NAME=?",new String[]{name1});

        return true;
    }

    public boolean insertDataCareer12(String name1, String location, String pack, String pos, String cmpn,String work,String education, String job,String dis) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2Cr1, name1);
        contentValues.put(col_3Cr1, location);
        contentValues.put(col_4Cr1, pack);
        contentValues.put(col_5Cr1, pos);
        contentValues.put(col_6Cr1, cmpn);
        contentValues.put(col_7Cr1, work);
        contentValues.put(col_8Cr1, education);
        contentValues.put(col_9Cr1, job);
        contentValues.put(col_10Cr1,dis);


        long result = db.insert(tableNameCareer12, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getDataCareer()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+tableNameCareer12,null);
        return res;
    }
    public void removeCareerData(String location)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("Delete from "+tableNameCareer12+" where LOCATION=?",new String[]{location});
    }

}
