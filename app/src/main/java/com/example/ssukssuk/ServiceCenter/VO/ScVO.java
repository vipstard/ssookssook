package com.example.ssukssuk.ServiceCenter.VO;

public class ScVO {

    private String num;
    private String writer;
    private String title;
    private String content;
    private String date;


    public ScVO() {
    }

    public ScVO(String title, String date) {
        this.title = title;
        this.date = date;
    }

    //constructor

    public ScVO(String writer, String title, String content, String date) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public ScVO(String num, String title, String date) {
        this.num = num;
        this.title = title;
        this.date = date;
    }


    //toString()


    @Override
    public String toString() {
        return "ScVO{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
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

    public String getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }


    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}