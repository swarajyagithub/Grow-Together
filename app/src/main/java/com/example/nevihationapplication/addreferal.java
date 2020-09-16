package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class addreferal extends AppCompatActivity  {
    TabLayout tabAR;
    TabItem tab1AR;
    TabItem tab2AR;
    TabItem tab3AR;
    TabItem tab4AR;
    TabItem tab5AR;

    ViewPager viewpgrAR;
    PageAdapterAR pageAdapterAR;

    Button addRe;
    TextView ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreferal);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabAR=findViewById(R.id.tablayoutAR);
        tab1AR=findViewById(R.id.tabitem1AR);
        tab2AR=findViewById(R.id.tabitem2AR);
        tab3AR=findViewById(R.id.tabitem3AR);
        tab4AR=findViewById(R.id.tabitem4AR);
        tab5AR=findViewById(R.id.tabitem5AR);
        viewpgrAR=findViewById(R.id.viewPagerAR);
      //  addRe=findViewById(R.id.addAR);


        final singleDatabase dbref=new singleDatabase(this);


        pageAdapterAR = new PageAdapterAR(getSupportFragmentManager(), tabAR.getTabCount());
        viewpgrAR.setAdapter(pageAdapterAR);
        tabAR.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpgrAR.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pageAdapterAR.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpgrAR.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabAR));



       // addRe.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
               // ii=findViewById(R.id.i);
                Intent intent=getIntent();
                String nm=intent.getStringExtra("NameR");
                String pn=intent.getStringExtra("PhoneR");
                String em=intent.getStringExtra("EmailR");
                String ad=intent.getStringExtra("AddR");
                String cm=intent.getStringExtra("CommentR");
                String n1=intent.getStringExtra("N");
               // boolean r2=dbref.insertDataReferral(nm,pn,em,ad,cm);
               // if(r2==true)
               // {
                  //  Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
             //   }
              //  else
             //   { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            //    }

               // ii.setText(n1);
         //  }
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

   // @Override
   // public void sendMessage(String name, String phone, final String email, String address, String comment) {
     //   addRe=findViewById(R.id.addAR);
      //  ii=findViewById(R.id.i);
      //  addRe.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
            //    ii.setText(email);
           // }
      //  });


}
