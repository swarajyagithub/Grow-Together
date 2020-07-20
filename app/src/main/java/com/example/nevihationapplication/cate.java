package com.example.nevihationapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;




import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class cate extends AppCompatActivity {

    CardView cardView;
    //EditText edit;
    GridView gridView;
  // SearchView searchView;



    arrayListName1 mydb2;
    ImageURLData3 data3;
    singleDatabase singleData;

//ArrayList
    ArrayList<String> nam=new ArrayList<String>();
    ArrayList<Integer> imgArrayInt=new ArrayList<Integer>();

//Imageview
    ImageView ag;
    ImageView gar;
    ImageView auto;
    ImageView cons;
    ImageView aud;
    ImageView it;
    ImageView edu;
    ImageView elec;

//TextView
    TextView agt;
    TextView gart;
    TextView autot;
    TextView constt;
    TextView audt;
    TextView itt;
    TextView edut;
    TextView elect;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//Finds image view from layout resource(activity_cate.xml)
        ag = findViewById(R.id.agriI);
        gar = findViewById(R.id.garmentI);
        auto = findViewById(R.id.automobileI);
        cons = findViewById(R.id.constI);
        aud = findViewById(R.id.auditI);
        it = findViewById(R.id.itI);
        edu = findViewById(R.id.educationI);
        elec = findViewById(R.id.eleI);

//Finds text view from layout resource(activity_cate.xml)
        agt = findViewById(R.id.angriT);
        gart = findViewById(R.id.garmentT);
        autot = findViewById(R.id.automobileT);
        constt = findViewById(R.id.constT);
        audt = findViewById(R.id.auditT);
        itt = findViewById(R.id.itT);
        edut = findViewById(R.id.educationT);
        elect = findViewById(R.id.eleT);

       // edit=findViewById(R.id.t);
    //  searchView=findViewById(R.id.search);
      //  gridView=findViewById(R.id.gridview);





        mydb2 = new arrayListName1(this);
        data3=new ImageURLData3(this);
        singleData=new singleDatabase(this);



        String a = "Agriculture & Farming";
        String b = "Apparel & Garments";
        String c = "Automobile, Parts & Spares";
        String d = "Building & Construction";
        String e = "Bussiness & Audit Services";
        String f = "Computer & IT Solutions";
        String g = "Education & Learning";
        String h = "Electronics";



 //getting identifier of drawable resources and storing it into database(imageURLData2)
        //First Image

       // String agriurl="@drawable/agri1";
     //  int url1=getResources().getIdentifier(agriurl,null,getPackageName());
    //    boolean r2=data.addImage(a,url1);

       // String aURL="@drawable/agri1";
       // int aURL1=getResources().getIdentifier(aURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(a,aURL1);





        //Second Image
       // String garurl="@drawable/gar";
       // int url2=getResources().getIdentifier(garurl,null,getPackageName());
    //  boolean r2= data3.addImage(url2);

       // String gURL="@drawable/gar";
      //  int gURL1=getResources().getIdentifier(gURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(b,gURL1);




        //Third image
        //String sparsurl="@drawable/saprs";
      //  int url3=getResources().getIdentifier(sparsurl,null,getPackageName());
     //  boolean r2= data3.addImage(url3);

     //   String auURL="@drawable/saprs";
      //  int auURL1=getResources().getIdentifier(auURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(c,auURL1);



      //  String surl="@drawable/saprs";
       // int spUrl=getResources().getIdentifier(surl,null,getPackageName());
      //  boolean r2=data.addImage(c,spUrl);


        // String bulidurl="@drawable/construction";
       // int url4=getResources().getIdentifier(bulidurl,null,getPackageName());
      //  boolean r2=data3.addImage(url4);

     //   String buiURL="@drawable/construction";
     //   int buiURL1=getResources().getIdentifier(buiURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(d,buiURL1);



       // String bUrl="@drawable/construction";
      //  int buildUrl=getResources().getIdentifier(bUrl,null,getPackageName());
       // boolean r2=data.addImage(d,buildUrl);

        //String auditurl="@drawable/audit1";
       //  int url5=getResources().getIdentifier(auditurl,null,getPackageName());
       //   boolean r2= data3.addImage(url5);


       // String audUrl="@drawable/audit1";
       // int aUrl=getResources().getIdentifier(audUrl,null,getPackageName());
      //  boolean r2=data.addImage(e,aUrl);

      //  String audURL="@drawable/audit1";
      //  int audURL1=getResources().getIdentifier(audURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(e,audURL1);


      //  String iturl="@drawable/it";
      //  int url6=getResources().getIdentifier(iturl,null,getPackageName());
     //   boolean r2= data3.addImage(url6);

        //String itURL="@drawable/it";
       // int itURL1=getResources().getIdentifier(itURL,null,getPackageName());
       // boolean r2=singleData.addCategory(f,itURL1);

      //  String itUrl="@drawable/it";
      //  int itU=getResources().getIdentifier(itUrl,null,getPackageName());
     //   boolean r2=data.addImage(f,itU);


      //  String eduurl="@drawable/education";
     //   int url7=getResources().getIdentifier(eduurl,null,getPackageName());
    //    boolean r2= data3.addImage(url7);


        //String eUrl="@drawable/educa";
        //int EUrl=getResources().getIdentifier(eUrl,null,getPackageName());
      //  boolean r2=data.addImage(g,EUrl);


      //  String eleurl="@drawable/ele";
      //  int url8=getResources().getIdentifier(eleurl,null,getPackageName());
      //  boolean r2= data3.addImage(url8);

       // String eleUrl="@drawable/ele";
      //  int elUrl=getResources().getIdentifier(eleUrl,null,getPackageName());
       // boolean r2=data.addImage(h,elUrl);

       // String elel="@drawable/ele";
      //  int urlC8=getResources().getIdentifier(elel,null,getPackageName());
      //  boolean r2=data.addImage(h,urlC8);


     //   String educurl="@drawable/educa";
      //  int url9=getResources().getIdentifier(educurl,null,getPackageName());
     //   boolean r2= data3.addImage(url9);

      //   String eleurl="@drawable/ele";
       //   int url9=getResources().getIdentifier(eleurl,null,getPackageName());
      //   boolean r2= data3.addImage(url9);

      //  String itu="@drawable/it";
      // int url10=getResources().getIdentifier(itu,null,getPackageName());
     //   boolean r2=data.addImage(f,url10);

       // String educat="@drawable/educa";
       // int url12=getResources().getIdentifier(educat,null,getPackageName());
       // boolean r2=data.addImage(g,url12);

       // String eduURL="@drawable/educa";
      //  int eduURL1=getResources().getIdentifier(eduURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(g,eduURL1);

        //String el="@drawable/ele";
       // int url13=getResources().getIdentifier(el,null,getPackageName());
      //  boolean r2=data.addImage(h,url13);

     //   String elURL="@drawable/ele";
      //  int elURL1=getResources().getIdentifier(elURL,null,getPackageName());
     //   boolean r2=singleData.addCategory(h,elURL1);



 //if image is inserted successfully,then display message "Data Inserted"
 //if(r2==true)
    //  {
    //  Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
     //  }
    //   else
     //   { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
   // }


        //code to clear data in arraylist
        imgArrayInt.clear();
        nam.clear();


        ag.setImageDrawable(null);
        gar.setImageDrawable(null);
        auto.setImageDrawable(null);
        cons.setImageDrawable(null);
        aud.setImageDrawable(null);
        it.setImageDrawable(null);
        edu.setImageDrawable(null);
        elec.setImageDrawable(null);

        agt.setText("");
        gart.setText("");
        autot.setText("");
        constt.setText("");
        audt.setText("");
        itt.setText("");
        edut.setText("");
        elect.setText("");

//Retrieving image identifier from database(imageURLData2)

     //  Cursor c2=data3.viewImageS();
      //  while (c2.moveToNext())
       //  {
        //   int i=c2.getInt(1);
          //    imgArrayInt.add(i);

       // }

 //Setting images to imageview.

       // Drawable res1=getResources().getDrawable(imgArrayInt.get(0));
    //  ag.setImageDrawable(getResources().getDrawable(imgArrayInt.get(0)));


    //    Drawable res2=getResources().getDrawable(imgArrayInt.get(1));
       // gar.setImageDrawable(getResources().getDrawable(imgArrayInt.get(1)));

       // Drawable res3=getResources().getDrawable(imgArrayInt.get(2));
      //  auto.setImageDrawable(getResources().getDrawable(imgArrayInt.get(2)));
    //   cons.setImageDrawable(getResources().getDrawable(imgArrayInt.get(3)));
     // aud.setImageDrawable(getResources().getDrawable(imgArrayInt.get(4)));
      //  it.setImageDrawable(getResources().getDrawable(imgArrayInt.get(5)));
      //  edu.setImageDrawable(getResources().getDrawable(imgArrayInt.get(6)));

     //   elec.setImageDrawable(getResources().getDrawable(imgArrayInt.get(7)));




//singleData.removeCategory(b);
Cursor cData=singleData.getCategory();
while (cData.moveToNext())
{
    String categoryName=cData.getString(1);
    int categoryImage=cData.getInt(2);
    nam.add(categoryName);
    imgArrayInt.add(categoryImage);
}
 ag.setImageDrawable(getResources().getDrawable(imgArrayInt.get(0)));
gar.setImageDrawable(getResources().getDrawable(imgArrayInt.get(1)));
auto.setImageDrawable(getResources().getDrawable(imgArrayInt.get(2)));
cons.setImageDrawable(getResources().getDrawable(imgArrayInt.get(3)));
aud.setImageDrawable(getResources().getDrawable(imgArrayInt.get(4)));
it.setImageDrawable(getResources().getDrawable(imgArrayInt.get(5)));
edu.setImageDrawable(getResources().getDrawable(imgArrayInt.get(6)));
elec.setImageDrawable(getResources().getDrawable(imgArrayInt.get(7)));
agt.setText(nam.get(0));
gart.setText(nam.get(1));
autot.setText(nam.get(2));
constt.setText(nam.get(3));
audt.setText(nam.get(4));
itt.setText(nam.get(5));
edut.setText(nam.get(6));
elect.setText(nam.get(7));







      //  mydb2.insertData(a);
    //    mydb2.insertData(b);
      //  mydb2.insertData(c);
     //   mydb2.insertData(d);
      //  mydb2.insertData(e);
     //   mydb2.insertData(f);
     //   mydb2.insertData(g);
     //   mydb2.insertData(h);










        //  Cursor c1 = mydb2.getdata();

     //  while (c1.moveToNext()) {
          //  String s = c1.getString(1);
          //  nam.add(s);

       // }

      //  agt.setText(nam.get(0));
     //   gart.setText(nam.get(1));
     //   autot.setText(nam.get(2));
     //   constt.setText(nam.get(3));
      //  audt.setText(nam.get(4));
      // itt.setText(nam.get(5));
     //  edut.setText(nam.get(6));
     //  elect.setText(nam.get(7));



       cardView=findViewById(R.id.cardIT);

        cardView.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
          Intent in=new Intent(cate.this, subcategory.class);
         startActivity(in);

    }
});








    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Infalater=getMenuInflater();
        Infalater.inflate(R.menu.drawermenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);

    }









}
