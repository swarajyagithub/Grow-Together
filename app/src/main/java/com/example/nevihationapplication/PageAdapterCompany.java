package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterCompany extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapterCompany(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new companyfragment();

            case 1:return new socilafragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
