package com.example.ssukssuk.Plant_reg;

public class PlantVO {
    private int potNum;
    private String potName;
    private String potDate;
    private String userId;

    public PlantVO(int potNum, String potName, String potDate, String userId) {
        this.potNum = potNum;
        this.potName = potName;
        this.potDate = potDate;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PlantVO{" +
                "potNum=" + potNum +
                ", potName='" + potName + '\'' +
                ", potDate='" + potDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public int getPotNum() {
        return potNum;
    }

    public void setPotNum(int potNum) {
        this.potNum = potNum;
    }

    public String getPotName() {
        return potName;
    }

    public void setPotName(String potName) {
        this.potName = potName;
    }

    public String getPotDate() {
        return potDate;
    }

    public void setPotDate(String potDate) {
        this.potDate = potDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}