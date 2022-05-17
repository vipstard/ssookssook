package com.example.ssukssuk.VO;

public class BoardVO_content {
    private String title;
    private String content;
    private String writer;
    private String date;
    public BoardVO_content(){}
    public BoardVO_content(String title, String content, String writer, String date) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BoardVO_content{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
