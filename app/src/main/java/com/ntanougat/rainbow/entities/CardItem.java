package com.ntanougat.rainbow.entities;


public class CardItem {

    private String g_id;
    private String imgUrl;

    public CardItem(String content,String imgUrl) {
        this.g_id = content;
        this.imgUrl = imgUrl;
    }


    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
