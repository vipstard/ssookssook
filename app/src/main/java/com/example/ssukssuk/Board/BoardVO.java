package com.example.ssukssuk.Board;

public class BoardVO {
    private String writer;
    private String title;
    private String content;
    private String date;
    public BoardVO(){}

    public BoardVO(String writer, String title, String date) {
        this.writer = writer;
        this.title = title;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public BoardVO(String date, String content, String writer, String title) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
