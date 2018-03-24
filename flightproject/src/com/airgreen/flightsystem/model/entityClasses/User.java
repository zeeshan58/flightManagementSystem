package com.airgreen.flightsystem.model.entityClasses;

public class User {
    private String uname;
    private String email;
    private String passport;
    private String cnic;
    private String phoneNo;
    private String addr;

    public User(){

    }
    public User(String uname, String email, String passport, String cnic, String phoneNo, String addr) {
        this.uname = uname;
        this.email = email;
        this.passport = passport;
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.addr = addr;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
