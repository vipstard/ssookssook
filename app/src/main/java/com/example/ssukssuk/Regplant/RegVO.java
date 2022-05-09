package com.example.ssukssuk.Regplant;

public class RegVO {
    String name;
    String type;

    public RegVO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void getType(String type) {
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
