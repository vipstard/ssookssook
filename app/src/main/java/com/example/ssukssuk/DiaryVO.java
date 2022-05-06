package com.example.ssukssuk;

public class DiaryVO {
    private int img;
    private String title;
    private String date;

    public DiaryVO(){}

    public DiaryVO(int img, String title, String date) {
        this.img = img;
        this.title = title;
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void getTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void getDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "img=" + img +
                ", title='" + title  +
                ", date='" + date  +
                '}';
    }
}
