package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterARH extends FragmentPagerAdapter {
    int tabcount;

    public PageAdapterARH(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new home();
            case 1:return new network();
            case 2:return new post();
            case 3:return new selections();
            case 4:return new account();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
