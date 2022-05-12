package com.example.ssukssuk.Plant_reg;

public class Reg_Plant_mainVO {
    private String pot_name;
    private String date;

    public Reg_Plant_mainVO(String pot_name, String date) {
        this.pot_name = pot_name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reg_Plant_mainVO{" +
                "pot_name='" + pot_name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getPot_name() {
        return pot_name;
    }

    public void setPot_name(String pot_name) {
        this.pot_name = pot_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
