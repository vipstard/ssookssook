package com.example.ssukssuk.Board_answerVO;

public class Board_answer_VO {
    private String date;
    private String content;
    private String writer;
    private String title;
    public Board_answer_VO(){}

    public Board_answer_VO(String date, String content, String writer) {
        this.date = date;
        this.content = content;
        this.writer = writer;
    }

    public Board_answer_VO(String date, String content, String writer, String title) {
        this.date = date;
        this.content = content;
        this.writer = writer;
        this.title = title;
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
