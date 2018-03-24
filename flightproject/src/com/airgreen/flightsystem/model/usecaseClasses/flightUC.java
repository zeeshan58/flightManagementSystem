package com.airgreen.flightsystem.model.usecaseClasses;

import com.airgreen.flightsystem.model.daoClasses.daoFlight;
import com.airgreen.flightsystem.model.entityClasses.User;
import com.airgreen.flightsystem.model.entityClasses.booking;
import com.airgreen.flightsystem.model.entityClasses.flight;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class flightUC {
    flight flightobj;
    DataSource dataSource;
    public flightUC(DataSource ds, flight f) {
        dataSource=ds;
        flightobj=f;
    }

    public flightUC(DataSource ds) {
        dataSource=ds;
        flightobj=new flight();
    }

    public void addFlight(){
        daoFlight daoFlightobj= new daoFlight(dataSource);
        daoFlightobj.addflight(flightobj);
        daoFlightobj.closeConn();
    }

    public List<flight> getAdminFlightList(){
        daoFlight daoFlightobj= new daoFlight(dataSource);

        List<flight> l= daoFlightobj.getAdminAddedFlights();
        daoFlightobj.closeConn();
        return l;
    }

    public List<flight> getSearchedFlightList(String d, String a ,String date){
        daoFlight daoFlightobj= new daoFlight(dataSource);

        List<flight> l= daoFlightobj.getSearchedAddedFlights(d,a,date);
        daoFlightobj.closeConn();
        return l;
    }

    public void updateFilghtData(flight f, String knum,Date kdate, Time ktime){

        daoFlight daoFlightobj= new daoFlight(dataSource);

        daoFlightobj.updateFlightData(f,knum,kdate,ktime);

        daoFlightobj.closeConn();
    }

    public User getUserByname(booking obj){

        daoFlight daoFlightobj= new daoFlight(dataSource);

        daoFlightobj.confirmFlight(obj);

        User u=daoFlightobj.getUserByname(obj.getUserName());
        daoFlightobj.closeConn();
        return u;
    }

    public flight getFlightById(booking obj){

        daoFlight daoFlightobj= new daoFlight(dataSource);

        daoFlightobj.confirmFlight(obj);

        flight f=daoFlightobj.getFlightById(obj.getFlightId());
        daoFlightobj.closeConn();
        return f;
    }

    public void managerUpdate(int _id,String appr){
        daoFlight daoFlightobj= new daoFlight(dataSource);

        daoFlightobj.managerUpdate(_id,appr);

        daoFlightobj.closeConn();
    }
}
