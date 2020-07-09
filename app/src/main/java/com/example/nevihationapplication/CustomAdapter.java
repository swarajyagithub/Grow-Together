package com.example.nevihationapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ImageView imageView;

    int im[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext,  int[] im) {
        this.context = context;

        this.im = im;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list, null);

      ImageView ic=(ImageView) view.findViewById(R.id.list_item);

        ic.setImageResource(im[i]);
        return view;
    }
}
