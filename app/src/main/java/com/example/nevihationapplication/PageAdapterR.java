package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterR  extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapterR(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new fragmentR1();

            case 1:return new fragmentR2();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
