package com.example.ssukssuk.VO;

public class Board_list_select_writeVO {
    private String date;
    private String content;
    private String writer;

    public Board_list_select_writeVO(String date, String content, String writer) {
        this.date = date;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Board_list_select_writeVO{" +
                "date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
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
