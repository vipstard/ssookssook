package com.example.ssukssuk.Board_answerVO;

public class Board_answer_VO {
    private String date;
    private String content;
    private String writer;
    public Board_answer_VO(){}

    public Board_answer_VO(String date, String content, String writer) {
        this.date = date;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Board_answer_VO{" +
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
    public void setDate( ) {
        this.date = date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setContent() {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public void setWriter() {
        this.writer = writer;
    }
}
