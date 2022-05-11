package com.example.ssukssuk.VO;

public class signVO {

    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String indate;

    public signVO(){}

    public signVO(String id, String pw, String name, String phone, String email, String address, String indate) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.indate = indate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "signVO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }


}
