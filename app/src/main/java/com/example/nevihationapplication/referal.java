package com.example.nevihationapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class referal extends AppCompatActivity {
    TabLayout tabR;
    TabItem tab1R;
    TabItem tab2R;
    ViewPager viewpgrR;
    PageAdapterR pageAdapterR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referal);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabR=findViewById(R.id.tablayoutR);
        tab1R=findViewById(R.id.tabitem1R);
        tab2R=findViewById(R.id.tabitem2R);
        viewpgrR=findViewById(R.id.viewPagerR);
        pageAdapterR= new PageAdapterR(getSupportFragmentManager(),tabR.getTabCount());
        viewpgrR.setAdapter(pageAdapterR);

        tabR.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpgrR.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pageAdapterR.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpgrR.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabR));
    }
}
