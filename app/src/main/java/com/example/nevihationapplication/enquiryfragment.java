

package com.example.nevihationapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class enquiryfragment extends AppCompatActivity {

    TabLayout tabL;
    TabItem tab1;
    TabItem tab2;
    ViewPager viewpgr;
    PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiryfragment);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabL=findViewById(R.id.tablayout);
        tab1=findViewById(R.id.tabitem1);
        tab2=findViewById(R.id.tabitem2);
        viewpgr=findViewById(R.id.viewPager);
        singleDatabase dataEn=new singleDatabase(this);

        pageAdapter=new PageAdapter(getSupportFragmentManager(),tabL.getTabCount());
        viewpgr.setAdapter(pageAdapter);

        tabL.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpgr.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpgr.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabL));
    }
}



