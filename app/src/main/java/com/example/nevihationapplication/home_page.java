package com.example.nevihationapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class home_page extends AppCompatActivity {
    TabLayout tabAR;
    TabItem tab1AR;
    TabItem tab2AR;
    TabItem tab3AR;
    TabItem tab4AR;
    TabItem tab5AR;

    ViewPager viewpgrAR;
    PageAdapterARH pageAdapterARH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tabAR=findViewById(R.id.tablayoutAR);
        tab1AR=findViewById(R.id.tabitem1AR);
        tab2AR=findViewById(R.id.tabitem2AR);
        tab3AR=findViewById(R.id.tabitem3AR);
        tab4AR=findViewById(R.id.tabitem4AR);
        tab5AR=findViewById(R.id.tabitem5AR);
        viewpgrAR=findViewById(R.id.viewPagerAR);
        pageAdapterARH = new PageAdapterARH(getSupportFragmentManager(), tabAR.getTabCount());
        viewpgrAR.setAdapter(pageAdapterARH);
        tabAR.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpgrAR.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pageAdapterARH.notifyDataSetChanged();
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

        tabAR.getTabAt(0).setIcon(R.drawable.homeicon);
        tabAR.getTabAt(1).setIcon(R.drawable.networkicon);
        tabAR.getTabAt(2).setIcon(R.drawable.posticon);
        tabAR.getTabAt(3).setIcon(R.drawable.seleicon);
       tabAR.getTabAt(4).setIcon(R.drawable.accounticon);


    }
}
