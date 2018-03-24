package com.airgreen.flightsystem.model.entityClasses;

public class booking {

    int bookingId;
    String userName;
    int flightId;
    String classOf;
    int adults;
    int infants;
    int children;
    int price;

    public booking(int bookingId, String userName, int flightId, String classOf, int adults, int infants, int children, int price) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.flightId = flightId;
        this.classOf = classOf;
        this.adults = adults;
        this.infants = infants;
        this.children = children;
        this.price = price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getClassOf() {
        return classOf;
    }

    public void setClassOf(String classOf) {
        this.classOf = classOf;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getInfants() {
        return infants;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
