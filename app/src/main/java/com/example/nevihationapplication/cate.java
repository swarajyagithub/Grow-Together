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
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class cate extends AppCompatActivity {

   // CardView cardView;
   // imageTT mydb;
   arrayListName1 mydb2;
   //arrayListNmae2 mydb3;
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

        ag=findViewById(R.id.agriI);
        gar=findViewById(R.id.garmentI);
        auto=findViewById(R.id.automobileI);
        cons=findViewById(R.id.constI);
        aud=findViewById(R.id.auditI);
        it=findViewById(R.id.itI);
        edu=findViewById(R.id.educationI);
        elec=findViewById(R.id.eleI);

        agt=findViewById(R.id.angriT);
        gart=findViewById(R.id.garmentT);
        autot=findViewById(R.id.automobileT);
        constt=findViewById(R.id.constT);
        audt=findViewById(R.id.auditT);
        itt=findViewById(R.id.itT);
        edut=findViewById(R.id.educationT);
        elect=findViewById(R.id.eleT);


       // mydb=new imageTT(this);
        mydb2=new arrayListName1(this);
       // mydb3=new arrayListNmae2(this);
       //  Bitmap bitmapA = BitmapFactory.decodeResource(getResources(), R.drawable.agri);
      //  Bitmap bitmapB = BitmapFactory.decodeResource(getResources(), R.drawable.gar);
      //  Bitmap bitmapC = BitmapFactory.decodeResource(getResources(), R.drawable.saprs);
       // Bitmap bitmapD = BitmapFactory.decodeResource(getResources(), R.drawable.construction);
       // Bitmap bitmapE = BitmapFactory.decodeResource(getResources(), R.drawable.audit1);
       // Bitmap bitmapF = BitmapFactory.decodeResource(getResources(), R.drawable.it);
     //   Bitmap bitmapG = BitmapFactory.decodeResource(getResources(), R.drawable.education);
        //Bitmap bitmapH = BitmapFactory.decodeResource(getResources(), R.drawable.ele);

        String a = "Agriculture & Farming";
        String b="Apparel & Garments";
        String c="Automobile, Parts & Spares";
        String d="Building & Construction";
        String e="Bussiness & Audit Services";
        String f="Computer & IT Solutions";
        String g="Education & Learning";
        String h="Electronics";

      //  ByteArrayOutputStream streamA = new ByteArrayOutputStream();
       // ByteArrayOutputStream streamB = new ByteArrayOutputStream();
      // ByteArrayOutputStream streamC = new ByteArrayOutputStream();
       // ByteArrayOutputStream streamD = new ByteArrayOutputStream();

      //  bitmapA.compress(Bitmap.CompressFormat.PNG,100,streamA);
      //  bitmapB.compress(Bitmap.CompressFormat.PNG,100,streamB);
      //  bitmapC.compress(Bitmap.CompressFormat.PNG,100,streamC);
   //     bitmapD.compress(Bitmap.CompressFormat.PNG,100,streamD);
     //   bitmapE.compress(Bitmap.CompressFormat.PNG,100,stream);
      //  bitmapF.compress(Bitmap.CompressFormat.PNG,100,stream);
     //   bitmapG.compress(Bitmap.CompressFormat.PNG,100,stream);
      //  bitmapH.compress(Bitmap.CompressFormat.PNG,100,stream);

      //   byte imageInByteA[] = streamA.toByteArray();
      //   byte imageInByteB[] = streamB.toByteArray();
      //  byte imageInByteC[] = streamC.toByteArray();
      //   byte imageInByteD[] = streamD.toByteArray();
     //   byte imageInByteE[] = stream.toByteArray();
     //   byte imageInByteF[] = stream.toByteArray();
      //  byte imageInByteG[] = stream.toByteArray();
       // byte imageInByteH[] = stream.toByteArray();

      // mydb3.insertImage(imageInByteA);
       // mydb3.insertImage(imageInByteB);
       // mydb3.insertImage(imageInByteC);
       // mydb3.insertImage(imageInByteD);

       // mydb2.insertData(a);
      //  mydb2.insertData(b);
      //  mydb2.insertData(c);
        //mydb2.insertData(d);
        //mydb2.insertData(e);
       // mydb2.insertData(f);
        //mydb2.insertData(g);
      //  mydb2.insertData(h);

        imgArray.clear();
        ag.setImageBitmap(null);
        gar.setImageBitmap(null);
        auto.setImageBitmap(null);
        cons.setImageBitmap(null);
        aud.setImageBitmap(null);
        it.setImageBitmap(null);
        edu.setImageBitmap(null);
        elec.setImageBitmap(null);

       nam.clear();
       agt.setText("");
       gart.setText("");
       autot.setText("");
       constt.setText("");
       audt.setText("");
       itt.setText("");
       edut.setText("");
       elect.setText("");


       Cursor c1=mydb2.getdata();
       while (c1.moveToNext())
       {
           String s=c1.getString(1);
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


     //  Cursor c2=mydb3.getImage();
    //   Bitmap bt=null;
       //while (c2.moveToNext())
      //{

         // byte[] img1=c2.getBlob(1);
      //   bt=BitmapFactory.decodeByteArray(img1,0,img1.length);
       //   imgArray.add(bt);

    //   }


     //  ag.setImageBitmap(imgArray.get(0));
    //  gar.setImageBitmap(imgArray.get(1));
    //  auto.setImageBitmap(imgArray.get(2));
    //  cons.setImageBitmap(imgArray.get(3));

      //  mydb.insertData(imageInByteA,a);



       // ag.setImageBitmap(mydb.viewImage());

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // cardView=findViewById(R.id.cardIT);
        //cardView.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
              //  Intent in=new Intent(cate.this, subcategory.class);
              //  startActivity(in);
           // }
      //  });

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
