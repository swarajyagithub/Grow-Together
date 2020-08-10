package com.example.nevihationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class agriculture extends AppCompatActivity {

singleDatabase dataagri;
    ArrayList<String> namAgriS=new ArrayList<String>();
    ArrayList<Integer> namAgriI=new ArrayList<Integer>();

    TextView t7;
    TextView t8;
    TextView t9;
    TextView t71;
    TextView t81;
    TextView t91;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataagri=new singleDatabase(this);

        t7=findViewById(R.id.txt1A);
        t71=findViewById(R.id.txt2A);
        t8=findViewById(R.id.txt3A);
        t81=findViewById(R.id.txt4A);
        t9=findViewById(R.id.txt5A);
        t91=findViewById(R.id.txt6A);

        int num7=4;
        int num8=1;
        int num9=1;
        String a7="01 Bird Seeds,Poultry & Animal Food";
        String b8="31 Farming & Pet Animals";
        String c9="81 Fresh Flowers,Plants & Trees";


        Boolean r1=dataagri.insertDataAgri(a7,num7);
        //Boolean r1=dataagri.insertDataS(b8,num8);
       // Boolean r1=dataagri.insertDataS(c9,num9);
          if(r1==true)
            {
          Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
          }
           else
          {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
          }




        namAgriS.clear();
        namAgriI.clear();
        t7.setText("");
        t71.setText("");
        t8.setText("");
        t81.setText("");
        t9.setText("");
        t91.setText("");


       // dataagri.removeSubCatData(a7);
      //  dataagri.removeSubCatData(b8);
      //  dataagri.removeSubCatData(c9);
      //  Cursor adriC=dataagri.getDataS();
     //   while (adriC.moveToNext())
      //  {
          //  String agriS=adriC.getString(1);
          //  int agriI=adriC.getInt(2);
         //   namAgriS.add(agriS);
         //   namAgriI.add(agriI);
       // }

       // t7.setText(namAgriS.get(3));
       // t71.setText(String.valueOf(namAgriI.get(3)));
        //t8.setText(namAgriS.get(4));
       // t81.setText(String.valueOf(namAgriI.get(4)));
       // t9.setText(namAgriS.get(5));
      //  t91.setText(String.valueOf(namAgriI.get(5)));






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

   // @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
      //   MenuInflater inflater=getMenuInflater();
      //   inflater.inflate(R.menu.filtericon,menu);

     //   return true;
   // }
}
