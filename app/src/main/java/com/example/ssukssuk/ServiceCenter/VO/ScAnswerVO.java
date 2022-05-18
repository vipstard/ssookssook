package com.example.ssukssuk.ServiceCenter.VO;

public class ScAnswerVO {
    private String title;
    private String content;
    private String date;
    private String writer;


    public ScAnswerVO(){}

    public ScAnswerVO(String title, String date) {
        this.title = title;
        this.date = date;
    }

    //constructor

    public ScAnswerVO(String writer, String title, String content, String date) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public ScAnswerVO(String writer, String content, String date) {
        this.writer = writer;
        this.content = content;
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}