package com.example.ssukssuk;

public class BoardVO {
    private String title;
    private String date;
    private String writer;

    @Override
    public String toString() {
        return "BoardVO{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", witer='" + writer + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWiter(String witer) {
        this.writer = witer;
    }

    public BoardVO(String title, String date, String writer) {
        this.title = title;
        this.date = date;
        this.writer = writer;
    }
}
