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
    ArrayList<Integer> nam2=new ArrayList<Integer>();
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



        t1=findViewById(R.id.abc);
        t2=findViewById(R.id.text12);
        t3=findViewById(R.id.text21);
        t4=findViewById(R.id.text22);
        t5=findViewById(R.id.text31);
        t6=findViewById(R.id.text32);

        s=new subData(this);


        int num4=5;
        int num5=4;
        int num6=1;
        String a1="81 Computer,IT & Software Training";
        String b1="191 Software Development & IT Consultant";
        String c1="211 Web Development & Marketing Services";

      // Boolean r1= s.insertDataS(a1,num4);
     // Boolean r2= s.insertDataS(b1,num5);
      // Boolean r3=s.insertDataS(c1,num6);
        //if(r1==true)
     //   {
        //    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
       // }
      //  else
       // {
           // Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
      //  }

        nam1.clear();
        nam2.clear();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");

        Cursor rS=s.getDataS();
        Cursor rN=s.getDataS();
        while (rS.moveToNext())
        {
            String s12=rS.getString(1);
            int i12=rS.getInt(2);
            nam1.add(s12);
            nam2.add(i12);
        }




        t1.setText(nam1.get(0));
        t2.setText(String.valueOf(nam2.get(0)));
       t3.setText(nam1.get(1));
        t4.setText(String.valueOf(nam2.get(1)));
        t5.setText(nam1.get(2));
        t6.setText(String.valueOf(nam2.get(2)));


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




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
