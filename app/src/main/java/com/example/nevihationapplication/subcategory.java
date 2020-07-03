package com.example.nevihationapplication;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class subcategory extends AppCompatActivity {

   subData s;

    ArrayList<String> nam1=new ArrayList<String>();
    ArrayList<Integer> nma2=new ArrayList<Integer>();
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        s=new subData(this);




        int num4=5;
        int num5=4;
        int num6=1;
        String a1="81 Computer,IT & Software Training";
        String b1="191 Software Development & IT Consultant";
        String c1="211 Web Development & Marketing Services";

      // Boolean r1= s.insertData(a1,num4);
      // Boolean r2= s.insertData(b1,num5);
      //  Boolean r3=s.insertData(c1,num6);
        //if(r1==true)
     //   {
        //    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
       // }
      //  else
       // {
           // Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
      //  }



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
