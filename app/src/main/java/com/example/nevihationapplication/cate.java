package com.example.nevihationapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

//import android.support.v7.widget.SearchView;

public class cate extends AppCompatActivity {

    CardView cardView;
    EditText edit;
    GridView gridView;
  // SearchView searchView;
   SearchView search1;



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

        edit=findViewById(R.id.t);
   //  searchView=findViewById(R.id.search);
      //  gridView=findViewById(R.id.gridview);

        search1=(SearchView)findViewById(R.id.search);





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


       // String aURL="@drawable/agri1";
       // int aURL1=getResources().getIdentifier(aURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(a,aURL1);


       // String gURL="@drawable/gar";
      //  int gURL1=getResources().getIdentifier(gURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(b,gURL1);


     //   String auURL="@drawable/saprs";
      //  int auURL1=getResources().getIdentifier(auURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(c,auURL1);


     //   String buiURL="@drawable/construction";
     //   int buiURL1=getResources().getIdentifier(buiURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(d,buiURL1);


      //  String audURL="@drawable/audit1";
      //  int audURL1=getResources().getIdentifier(audURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(e,audURL1);



        //String itURL="@drawable/it";
       // int itURL1=getResources().getIdentifier(itURL,null,getPackageName());
       // boolean r2=singleData.addCategory(f,itURL1);



       // String eduURL="@drawable/educa";
      //  int eduURL1=getResources().getIdentifier(eduURL,null,getPackageName());
      //  boolean r2=singleData.addCategory(g,eduURL1);



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

 edit.addTextChangedListener(new TextWatcher() {
     @Override
     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

     }

     @Override
     public void onTextChanged(CharSequence s, int start, int before, int count) {

     }

     @Override
     public void afterTextChanged(Editable s) {

     }
 });



 search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
     @Override
     public boolean onQueryTextSubmit(String query) {
         return false;
     }

     @Override
     public boolean onQueryTextChange(String newText) {
         return false;
     }
 });

























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
