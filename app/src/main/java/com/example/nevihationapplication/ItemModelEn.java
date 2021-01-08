package com.example.nevihationapplication;

public class ItemModelEn {
    private String nameEn;
    private String nameNm;
    private int nameMb;
    private String nameEm;

    public ItemModelEn(String nameEn, String nameNm, int nameMb, String nameEm) {
        this.nameEn = nameEn;
        this.nameNm = nameNm;
        this.nameMb = nameMb;
        this.nameEm = nameEm;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameNm() {
        return nameNm;
    }

    public void setNameNm(String nameNm) {
        this.nameNm = nameNm;
    }

    public int getNameMb() {
        return nameMb;
    }

    public void setNameMb(int nameMb) {
        this.nameMb = nameMb;
    }

    public String getNameEm() {
        return nameEm;
    }

    public void setNameEm(String nameEm) {
        this.nameEm = nameEm;
    }
}
