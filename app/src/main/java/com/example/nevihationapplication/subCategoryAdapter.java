package com.example.nevihationapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class subCategoryAdapter extends BaseAdapter {
    Context context;
    String tList[];
    int nList[];
    LayoutInflater inflter;

    public  subCategoryAdapter(Context applicationContext, String[] tList, int[] nList)
    {
        this.context=applicationContext;
        this.tList=tList;
        this.nList=nList;
    }

    @Override
    public int getCount() {
        return tList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view=inflter.inflate(R.layout.subcategory_item,null);
        TextView t=(TextView)view.findViewById(R.id.textlistitem);
        TextView n = (TextView) view.findViewById(R.id.textlistitem2);
        t.setText(tList[position]);
        n.setText(nList[position]);
        return view;

    }
}
