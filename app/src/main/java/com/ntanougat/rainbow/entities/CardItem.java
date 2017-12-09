package com.ntanougat.rainbow.entities;


public class CardItem {

    private String content;
    private String imgUrl;

    public CardItem(String content,String imgUrl) {
        this.content = content;
        this.imgUrl = imgUrl;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
