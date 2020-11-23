package com.example.nevihationapplication;

class ItemModelPostN {
    private String profilepicN;
    private String namN;
    private String postdataN;
    private  String postimageN;

    public ItemModelPostN(String profilepicN, String namN, String postdataN, String postimageN) {
        this.profilepicN = profilepicN;
        this.namN = namN;
        this.postdataN = postdataN;
        this.postimageN = postimageN;
    }

    public String getProfilepicN() {
        return profilepicN;
    }

    public void setProfilepicN(String profilepicN) {
        this.profilepicN = profilepicN;
    }

    public String getNamN() {
        return namN;
    }

    public void setNamN(String namN) {
        this.namN = namN;
    }

    public String getPostdataN() {
        return postdataN;
    }

    public void setPostdataN(String postdataN) {
        this.postdataN = postdataN;
    }

    public String getPostimageN() {
        return postimageN;
    }

    public void setPostimageN(String postimageN) {
        this.postimageN = postimageN;
    }
}
