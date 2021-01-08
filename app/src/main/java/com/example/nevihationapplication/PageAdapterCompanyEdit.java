package com.example.nevihationapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterCompanyEdit extends FragmentPagerAdapter {
    int tabcountEdit;
    public PageAdapterCompanyEdit(FragmentManager fm,int behaviour) {
        super(fm);
        tabcountEdit=behaviour;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new companyedit1();

            case 1:return new companyedit2();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcountEdit;
    }
}
