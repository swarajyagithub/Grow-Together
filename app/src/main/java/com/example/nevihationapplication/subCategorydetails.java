package com.example.nevihationapplication;

public class subCategorydetails {
    private String text;
    private int num;

    public subCategorydetails(String text, int num)
    {
        this.setText(text);
        this.setNum(num);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
