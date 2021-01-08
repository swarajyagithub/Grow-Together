package com.example.nevihationapplication;

class ItemModelService {
    private String companyNameGS;
    private String productNameGS;
    private String prizeGS;
    private String currencyGS;
    private String imageGS;

    public ItemModelService(String companyNameGS, String productNameGS, String prizeGS, String currencyGS, String imageGS) {
        this.companyNameGS = companyNameGS;
        this.productNameGS = productNameGS;
        this.prizeGS = prizeGS;
        this.currencyGS = currencyGS;
        this.imageGS = imageGS;
    }

    public String getCompanyNameGS() {
        return companyNameGS;
    }

    public void setCompanyNameGS(String companyNameGS) {
        this.companyNameGS = companyNameGS;
    }

    public String getProductNameGS() {
        return productNameGS;
    }

    public void setProductNameGS(String productNameGS) {
        this.productNameGS = productNameGS;
    }

    public String getPrizeGS() {
        return prizeGS;
    }

    public void setPrizeGS(String prizeGS) {
        this.prizeGS = prizeGS;
    }

    public String getCurrencyGS() {
        return currencyGS;
    }

    public void setCurrencyGS(String currencyGS) {
        this.currencyGS = currencyGS;
    }

    public String getImageGS() {
        return imageGS;
    }

    public void setImageGS(String imageGS) {
        this.imageGS = imageGS;
    }
}
