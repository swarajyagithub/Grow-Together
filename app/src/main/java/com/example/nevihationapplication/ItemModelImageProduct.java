package com.example.nevihationapplication;

class ItemModelImageProduct {
    private int imgProduct;
    private String nameProduct;

    public ItemModelImageProduct(int imgProduct, String nameProduct) {
        this.imgProduct = imgProduct;
        this.nameProduct = nameProduct;
    }

    public int getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
