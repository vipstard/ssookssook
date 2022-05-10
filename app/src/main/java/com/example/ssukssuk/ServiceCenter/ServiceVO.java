package com.example.ssukssuk.ServiceCenter;

public class ServiceVO {

    private String title;
    private String date;
    private String writer;

    public ServiceVO(){}

    //constructor
    public ServiceVO(String title, String date,String writer) {
        this.title = title;
        this.date = date;
        this.writer = writer;
    }

    //toString()
    @Override
    public String toString() {
        return "ServiceVO{" +
                "title='" + title + '\'' +
                ", data='" + date + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    //Getter
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getWriter() {
        return writer;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


}
