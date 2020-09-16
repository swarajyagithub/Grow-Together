package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterAR extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapterAR(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new r1();
            case 1:return new r2();
            case 2:return new r3();
            case 3:return new r4();
            case 4:return new r5();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
