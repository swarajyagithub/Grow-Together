package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterNei extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapterNei(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new myneibgbhorsfrag();
            case 1:return new myfavouritesfrag();

            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
