package com.example.ssukssuk.VO;

public class Reg_Plant_mainVO {
    int num;
    String Pot_name;
    String Pot_date;
    String user_name;

    public Reg_Plant_mainVO(int num, String pot_name, String pot_date, String user_name) {
        this.num = num;
        Pot_name = pot_name;
        Pot_date = pot_date;
        this.user_name = user_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPot_name() {
        return Pot_name;
    }

    public void setPot_name(String pot_name) {
        Pot_name = pot_name;
    }

    public String getPot_date() {
        return Pot_date;
    }

    public void setPot_date(String pot_date) {
        Pot_date = pot_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Reg_Plant_mainVO{" +
                "num=" + num +
                ", Pot_name='" + Pot_name + '\'' +
                ", Pot_date='" + Pot_date + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
