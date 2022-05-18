package com.example.ssukssuk.ServiceCenter.VO;

public class ScAnswerVO {
    private String date;
    private String content;
    private String writer;


    public ScAnswerVO() {
    }

    @Override
    public String toString() {
        return "ScAnswerVO{" +
                "date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public ScAnswerVO(String date, String content, String writer) {
        this.date = date;
        this.content = content;
        this.writer = writer;
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
}