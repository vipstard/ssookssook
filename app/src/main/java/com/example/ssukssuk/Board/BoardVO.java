package com.example.ssukssuk.Board;

public class BoardVO {
    private String title;
    private String date;
    private String writer;

    public BoardVO(){}

    public BoardVO(String writer, String title, String date) {
        this.title = title;
        this.date = date;
        this.writer = writer;
    }
    public void getTitle(String title) {
        this.title = title;
    }

    public void getDate(String date) {
        this.date = date;
    }

    public void getWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getWriter() {
        return writer;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                " writer='" + writer + '\'' +
                ",title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }



}
