package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapter(FragmentManager fm,int behaviour) {
        super(fm);
        tabcount=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new BlankFragment();

            case 1:return new BlankFragment2();
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
