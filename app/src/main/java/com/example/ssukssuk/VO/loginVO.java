package com.example.ssukssuk.VO;

public class loginVO {
    String id;
    String pw;
    public loginVO(){}

    public loginVO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "loginVO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
