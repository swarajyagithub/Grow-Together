package com.example.nevihationapplication;

import java.util.ArrayList;

public class Item {
    ArrayList<String> name=new ArrayList<String>();
    ArrayList<Integer> image=new ArrayList<Integer>();

    ArrayList<String> name1=new ArrayList<String>();
    ArrayList<Integer> image1=new ArrayList<Integer>();

    public Item( String s,ArrayList<Integer> image1) {
        this.name = name1;
        this.image = image1;
    }

    public Item(String s, Integer integer) {
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<Integer> getImage() {
        return image;
    }

    public void setImage(ArrayList<Integer> image) {
        this.image = image;
    }
}
