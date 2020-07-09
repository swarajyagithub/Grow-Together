package com.example.nevihationapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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
import java.util.ArrayList;

public class cate extends AppCompatActivity {

    CardView cardView;

  arrayListName1 mydb2;
 databaseImage mydbimg;




    ArrayList<String> nam=new ArrayList<String>();
    ArrayList<Bitmap>  imgArray=new ArrayList<Bitmap>();

    ImageView ag;
    ImageView gar;
    ImageView auto;
    ImageView cons;
    ImageView aud;
    ImageView it;
    ImageView edu;
    ImageView elec;

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



        ag = findViewById(R.id.agriI);
        gar = findViewById(R.id.garmentI);
        auto = findViewById(R.id.automobileI);
        cons = findViewById(R.id.constI);
        aud = findViewById(R.id.auditI);
        it = findViewById(R.id.itI);
        edu = findViewById(R.id.educationI);
        elec = findViewById(R.id.eleI);

        agt = findViewById(R.id.angriT);
        gart = findViewById(R.id.garmentT);
        autot = findViewById(R.id.automobileT);
        constt = findViewById(R.id.constT);
        audt = findViewById(R.id.auditT);
        itt = findViewById(R.id.itT);
        edut = findViewById(R.id.educationT);
        elect = findViewById(R.id.eleT);


        // mydb=new imageTT(this);
        mydb2 = new arrayListName1(this);
        mydbimg=new databaseImage(this);



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


       //ByteArrayOutputStream stream1=new ByteArrayOutputStream();
       //bitmap1.compress(Bitmap.CompressFormat.PNG,100,stream1);
       //byte[] img1=stream1.toByteArray();
      // boolean r1=mydbimg.addImage(img1);

      //  ByteArrayOutputStream stream2=new ByteArrayOutputStream();
     //   bitmap2.compress(Bitmap.CompressFormat.PNG,100,stream2);
       // byte[] img2=stream2.toByteArray();
      //  boolean r2=mydbimg.addImage(img2);

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

        //ByteArrayOutputStream stream7=new ByteArrayOutputStream();
       // bitmap7.compress(Bitmap.CompressFormat.PNG,100,stream7);
       //byte[] img7=stream7.toByteArray();
        //boolean r7=mydbimg.addImage(img7);

        //ByteArrayOutputStream stream8=new ByteArrayOutputStream();
        //bitmap8.compress(Bitmap.CompressFormat.PNG,100,stream8);
        //byte[] img8=stream8.toByteArray();
        //boolean r8=mydbimg.addImage(img8);

       // ByteArrayOutputStream stream9=new ByteArrayOutputStream();
      //  bitmap7.compress(Bitmap.CompressFormat.PNG,100,stream9);
      //  byte[] img9=stream9.toByteArray();
      //  boolean r9=mydbimg.addImage(img9);



      //  if(r9==true)
       //{
        //   Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
      // }
      // else
      // {
          // Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
       //}





        imgArray.clear();
       ag.setImageBitmap(null);
       gar.setImageBitmap(null);
        auto.setImageBitmap(null);
        cons.setImageBitmap(null);
        aud.setImageBitmap(null);
        it.setImageBitmap(null);
       edu.setImageBitmap(null);
       elec.setImageBitmap(null);







        mydb2.insertData(a);
        mydb2.insertData(b);
        mydb2.insertData(c);
        mydb2.insertData(d);
        mydb2.insertData(e);
        mydb2.insertData(f);
        mydb2.insertData(g);
        mydb2.insertData(h);



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

        //Cursor cursor1=mydbimg.viewImage();
       // Bitmap bit1;
       // while (cursor1.moveToNext()) {
           // byte[] imgb = cursor1.getBlob(1);
           // bit1 = BitmapFactory.decodeByteArray(imgb, 0, imgb.length);
            //imgArray.add(bit1);
     //   }
        //ag.setImageBitmap(imgArray.get(0));















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
