package com.example.ssukssuk.Regplant;

public class RegVO {
    String name;
    String type;

    public RegVO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getname() {
        return name;
    }

    public void getname(String name) {
        this.name = name;
    }

    public String gettype() {
        return type;
    }

    public void gettype(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegVO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
