package com.example.ssukssuk.VO;

public class PlantVO {

    private String potName;
    private String potDate;
    private String userId;
    public PlantVO(){}
    public PlantVO( String potName, String potDate, String userId) {
        this.potName = potName;
        this.potDate = potDate;
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "PlantVO{" +
                "potName='" + potName + '\'' +
                ", potDate='" + potDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
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