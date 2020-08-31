package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class saveCompany extends AppCompatActivity {
    TabLayout tabLComEdit;
    TabItem tab1Edit;
    TabItem tab2Edit;
    ViewPager viewpageComEdit;
    PageAdapterCompanyEdit pageAdapterCEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_company);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLComEdit=findViewById(R.id.tablayoutComEdit);
        tab1Edit=findViewById(R.id.tabitemCom1Edit);
        tab2Edit=findViewById(R.id.tabitemCom2Edit);
        viewpageComEdit=findViewById(R.id.viewPagerComEdit);


        pageAdapterCEdit=new PageAdapterCompanyEdit(getSupportFragmentManager(),tabLComEdit.getTabCount());
        viewpageComEdit.setAdapter(pageAdapterCEdit);

       tabLComEdit.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewpageComEdit.setCurrentItem(tab.getPosition());
               if(tab.getPosition()==0||tab.getPosition()==1)
               {
                   pageAdapterCEdit.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
       viewpageComEdit.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLComEdit));

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
