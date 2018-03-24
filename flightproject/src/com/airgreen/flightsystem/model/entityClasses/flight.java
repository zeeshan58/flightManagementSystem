package com.airgreen.flightsystem.model.entityClasses;



import java.sql.Time;
import java.util.Date;

public class flight {

    private int flightId;
    private String flightNum;
    private Date date;
    private Time time;
    private String from;
    private String to;
    private int fcSeats;
    private int fcSeatPrice;
    private int ecSeats;
    private int ecSeatPrice;
    private int bcSeats;
    private int bcSeatPrice;
    private int duration;
    private String  approved;

    public flight() {
    }
    public flight(int flightId, String flightNum, Date date, Time time, String from, String to, int fcSeats, int fcSeatPrice, int ecSeats, int ecSeatPrice, int bcSeats, int bcSeatPrice, int duration, String approved) {

        this.flightId = flightId;
        this.flightNum = flightNum;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
        this.fcSeats = fcSeats;
        this.fcSeatPrice = fcSeatPrice;
        this.ecSeats = ecSeats;
        this.ecSeatPrice = ecSeatPrice;
        this.bcSeats = bcSeats;
        this.bcSeatPrice = bcSeatPrice;
        this.duration = duration;
        this.approved = approved;
    }
    public flight(String flightNum, Date date, Time time, String from, String to, int fcSeats, int fcSeatPrice, int ecSeats, int ecSeatPrice, int bcSeats, int bcSeatPrice, int duration, String approved) {
        this.flightNum = flightNum;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
        this.fcSeats = fcSeats;
        this.fcSeatPrice = fcSeatPrice;
        this.ecSeats = ecSeats;
        this.ecSeatPrice = ecSeatPrice;
        this.bcSeats = bcSeats;
        this.bcSeatPrice = bcSeatPrice;
        this.duration = duration;
        this.approved = approved;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFcSeats(int fcSeats) {
        this.fcSeats = fcSeats;
    }

    public void setFcSeatPrice(int fcSeatPrice) {
        this.fcSeatPrice = fcSeatPrice;
    }

    public void setEcSeats(int ecSeats) {
        this.ecSeats = ecSeats;
    }

    public void setEcSeatPrice(int ecSeatPrice) {
        this.ecSeatPrice = ecSeatPrice;
    }

    public void setBcSeats(int bcSeats) {
        this.bcSeats = bcSeats;
    }

    public void setBcSeatPrice(int bcSeatPrice) {
        this.bcSeatPrice = bcSeatPrice;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getFlightNum() {

        return flightNum;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getFcSeats() {
        return fcSeats;
    }

    public int getFcSeatPrice() {
        return fcSeatPrice;
    }

    public int getEcSeats() {
        return ecSeats;
    }

    public int getEcSeatPrice() {
        return ecSeatPrice;
    }

    public int getBcSeats() {
        return bcSeats;
    }

    public int getBcSeatPrice() {
        return bcSeatPrice;
    }

    public int getDuration() {
        return duration;
    }

    public String getApproved() {
        return approved;
    }
}
