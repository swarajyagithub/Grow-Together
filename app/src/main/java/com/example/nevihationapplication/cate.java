package com.example.nevihationapplication;

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
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;

public class cate extends AppCompatActivity {

    CardView cardView;

 //Database instance
  arrayListName1 mydb2;
 databaseImage mydbimg;
 photoDatabase photo;
 imageAsString imgstring;
 imageStringURL imgurl;
 imageURLData2 urlimgint;




//ArrayList
    ArrayList<String> nam=new ArrayList<String>();
    ArrayList<Bitmap>  imgArray=new ArrayList<Bitmap>();
    ArrayList<String> namS=new ArrayList<String>();
    ArrayList<Integer> imgArrayInt=new ArrayList<Integer>();

//Imagevie
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
    private Instant Glide;


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


        mydb2 = new arrayListName1(this);
        mydbimg=new databaseImage(this);
        photo=new photoDatabase(this);
        imgstring=new imageAsString(this);
        imgurl=new imageStringURL(this);
        urlimgint=new imageURLData2(this);


//Getting resource from drawable and converting it into bitmap.
         Bitmap bitmap1=BitmapFactory.decodeResource(getResources(),R.drawable.agri);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.gar);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.saprs);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.construction);
       Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.audit1);
        Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.it);
        Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.education);
        Bitmap bitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.ele);



        String a = "Agriculture & Farming";
        String b = "Apparel & Garments";
        String c = "Automobile, Parts & Spares";
        String d = "Building & Construction";
        String e = "Bussiness & Audit Services";
        String f = "Computer & IT Solutions";
        String g = "Education & Learning";
        String h = "Electronics";



//Code for converting drawable image into string and storing that string into database(imageAsString:Database name)
      ByteArrayOutputStream stream1=new ByteArrayOutputStream();
      bitmap1.compress(Bitmap.CompressFormat.PNG,100,stream1);
      byte[] img1=stream1.toByteArray();
     String ims1=Base64.encodeToString(img1,1);

//Inserting image into database(imageAsString)    Storing image as String.
     boolean r1=imgstring.addImage(ims1);

//Code for converting image into byte and storing it into database(databaseImage:Name of database)
        ByteArrayOutputStream stream2=new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.PNG,100,stream2);
        byte[] img2=stream2.toByteArray();
//Inserting image into database(databaseImage)   Storing images as BLOB.
       boolean r2=mydbimg.addImage(img2);

       // ByteArrayOutputStream stream3=new ByteArrayOutputStream();
       // bitmap3.compress(Bitmap.CompressFormat.PNG,100,stream3);
      //  byte[] img3=stream3.toByteArray();
      //  boolean r3=mydbimg.addImage(img3);

     //   ByteArrayOutputStream stream4=new ByteArrayOutputStream();
      //  bitmap4.compress(Bitmap.CompressFormat.PNG,100,stream4);
      //  byte[] img4=stream4.toByteArray();
     //   boolean r4=mydbimg.addImage(img4);

       // ByteArrayOutputStream stream5=new ByteArrayOutputStream();
     //   bitmap5.compress(Bitmap.CompressFormat.PNG,100,stream5);
     //   byte[] img5=stream5.toByteArray();
      //  boolean r5=mydbimg.addImage(img5);

       // ByteArrayOutputStream stream6=new ByteArrayOutputStream();
       // bitmap6.compress(Bitmap.CompressFormat.PNG,100,stream6);
      //  byte[] img6=stream6.toByteArray();
       // boolean r6=mydbimg.addImage(img6);





//Code for retrieving image from databse(databaseImage)

     Cursor cimg=mydbimg.viewImage();
        Bitmap bit1=null;

      while (cimg.moveToNext())
      {
           byte[] imgb = cimg.getBlob(1);
           bit1 = BitmapFactory.decodeByteArray(imgb, 0, imgb.length);
           ag.setImageBitmap(bit1);
       }


//code to clear data in arraylist
        imgArray.clear();

//Code to remove image(ImageView)
     ag.setImageBitmap(null);
      gar.setImageBitmap(null);
        auto.setImageBitmap(null);
        cons.setImageBitmap(null);
        aud.setImageBitmap(null);
        it.setImageBitmap(null);
       edu.setImageBitmap(null);
       elec.setImageBitmap(null);

//Code to get url of drawabale resource(e.g. R.drawable.agri)
       Uri pathadri= Uri.parse("android.resource://android/drawable/agri");
       Uri patha=Uri.parse("android.resource://com.segf4ult.test"+R.drawable.agri);

//code to convert url into string
        String sagri=pathadri.toString();

//getting url of drawable resource and converting it into string.
       String agriS= Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +R.drawable.agri).toString();

 //code for adding url as string into database(databaseimage)
       mydbimg.addImageUrl(agriS);
 //code for inserting url as string into database(imageAsString)
        imgstring.deleteData();
        boolean r1=imgurl.addImage(agriS);

//code for retrieving image from database(imageAsString)
        Cursor curl=imgurl.viewImageU();
        while (curl.moveToNext())
        {
            String s2=curl.getString(1);
            namS.add(s2);
        }

 //getting identifier of drawable resources and storing it into database(imageURLData2)
        //First Image
        String agriurl="@drawable/agri";
        int igr=getResources().getIdentifier(agriurl,null,getPackageName());

        //Second Image
        String garurl="@drwable/gar";
        int gari=getResources().getIdentifier(garurl,null,getPackageName());

        //Third image
        int conI=getResources().getIdentifier("@drawable/a",null,getPackageName());

  //Inserting image into database(imageURLData2)
        urlimgint.addImage(igr);
        urlimgint.addImage(gari);
     boolean r2= urlimgint.addImage(conI);

 //if image is inserted successfully,then display message "Data Inserted"
    if(r2==true)
          {
         Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
          }
         else
         {
         Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

//Retrieving image identifier from database(imageURLData2)
        imgArrayInt.clear();
        Cursor cursor=urlimgint.viewImageS();
         while (cursor.moveToNext())
         {
            int i=cursor.getInt(1);
              imgArrayInt.add(i);
                 }

 //Setting images to imageview.
          ag.setImageDrawable(null);
        Drawable res=getResources().getDrawable(imgArrayInt.get(0));
       ag.setImageDrawable(res);

          gar.setImageDrawable(null);
        Drawable res1=getResources().getDrawable(imgArrayInt.get(1));
        gar.setImageDrawable(res1);

        Drawable autoD=getResources().getDrawable(imgArrayInt.get(2));
         auto.setImageDrawable(autoD);

        //Glide.with(this).load(namS.get(0)).into(ag);










      //  mydb2.insertData(a);
    //    mydb2.insertData(b);
      //  mydb2.insertData(c);
     //   mydb2.insertData(d);
      //  mydb2.insertData(e);
     //   mydb2.insertData(f);
     //   mydb2.insertData(g);
     //   mydb2.insertData(h);



        nam.clear();
        agt.setText("");
        gart.setText("");
        autot.setText("");
        constt.setText("");
        audt.setText("");
        itt.setText("");
        edut.setText("");
        elect.setText("");


        Cursor c1 = mydb2.getdata();

        while (c1.moveToNext()) {
            String s = c1.getString(1);
            nam.add(s);

        }

        agt.setText(nam.get(0));
        gart.setText(nam.get(1));
        autot.setText(nam.get(2));
        constt.setText(nam.get(3));
        audt.setText(nam.get(4));
       itt.setText(nam.get(5));
        edut.setText(nam.get(6));
        elect.setText(nam.get(7));






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
