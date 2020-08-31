package com.example.nevihationapplication;

public class ItemModelCompany {
    private String comName;
    private String ceoName;
    private String comEmail;
    private String comCity;
    private String comMobile;

    public ItemModelCompany(String comName, String ceoName, String comEmail, String comCity, String comMobile) {
        this.comName = comName;
        this.ceoName = ceoName;
        this.comEmail = comEmail;
        this.comCity = comCity;
        this.comMobile = comMobile;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public String getComCity() {
        return comCity;
    }

    public void setComCity(String comCity) {
        this.comCity = comCity;
    }

    public String getComMobile() {
        return comMobile;
    }

    public void setComMobile(String comMobile) {
        this.comMobile = comMobile;
    }
}
