

package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class editCompany extends AppCompatActivity {

    TabLayout tabLCom;
    TabItem tab1;
    TabItem tab2;
    ViewPager viewpageCom;
    PageAdapterCompany pageAdapterC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLCom=findViewById(R.id.tablayoutCom);
        tab1=findViewById(R.id.tabitemCom1);
        tab2=findViewById(R.id.tabitemCom2);
        viewpageCom=findViewById(R.id.viewPagerCom);

        pageAdapterC=new PageAdapterCompany(getSupportFragmentManager(),tabLCom.getTabCount());
        viewpageCom.setAdapter(pageAdapterC);

       tabLCom.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewpageCom.setCurrentItem(tab.getPosition());
               if(tab.getPosition()==0||tab.getPosition()==1)
               {
                   pageAdapterC.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

        viewpageCom.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLCom));

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



