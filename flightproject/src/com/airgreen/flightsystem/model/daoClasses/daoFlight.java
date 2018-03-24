package com.airgreen.flightsystem.model.daoClasses;

import com.airgreen.flightsystem.model.entityClasses.User;
import com.airgreen.flightsystem.model.entityClasses.booking;
import com.airgreen.flightsystem.model.entityClasses.flight;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.AM;

public class daoFlight extends DaoClass {
    public daoFlight(DataSource ds) {
        super(ds);
    }

    public void addflight(flight inFlight){

        try {
           // Statement statement = getConnection().createStatement();

//            String sql = "INSERT INTO flight (number, date, time, from, to, fcSeats, fcSeatPrice, ecSeats, ecSeatPrice, bcSeats, bcSeatPrice, duration, approved)" +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            String sql = "INSERT INTO flightpro.flight VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



            // String sql = "INSERT INTO temp (col)" +
             //       "VALUES (?)";



/*            String lastCrawlDate = inFlight.getDate().toString();
            Date utilDate = null;
            try {
                utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
// because PreparedStatement#setDate(..) expects a java.sql.Date argument
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


            String time = inFlight.getTime().toString();
            Date date = null;

            try {
                date = new SimpleDateFormat("HH:mm").parse(time);
            }
            catch (ParseException e) {

            }*/

            // because PreparedStatement#setDate(..) expects a java.sql.Date argument
            java.sql.Date sqlDate = new java.sql.Date(inFlight.getDate().getTime());

           PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, inFlight.getFlightNum());
           // preparedStatement.setDate(2, sqlDate);
            //preparedStatement.setTime(3, new Time(date.getTime()));
            preparedStatement.setString(3, inFlight.getApproved());
            preparedStatement.setString(4, inFlight.getFrom());
            preparedStatement.setString(5, inFlight.getTo());
            preparedStatement.setInt(6, inFlight.getFcSeats());
            preparedStatement.setInt(7, inFlight.getFcSeatPrice());
            preparedStatement.setInt(8, inFlight.getEcSeats());
            preparedStatement.setInt(9, inFlight.getEcSeatPrice());
            preparedStatement.setInt(10, inFlight.getBcSeats());
            preparedStatement.setInt(11, inFlight.getBcSeatPrice());
            preparedStatement.setInt(12, inFlight.getDuration());
            preparedStatement.setDate(13, sqlDate);
            preparedStatement.setTime(14,(Time) inFlight.getTime());
          //  PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, 15);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Issue in addFlight of daoFlight while interacting with db");
        }


    }

    public void confirmFlight(booking obj){
        int pSeats;
        PreparedStatement preparedStatement = null;

        if(obj.getClassOf().equals("Economy Class")){
            pSeats=getEconomySeats(obj.getFlightId());
            pSeats=pSeats-obj.getAdults()-obj.getChildren();

            String sql = "UPDATE flight SET ecSeats=? where flightId=?";
            try {

                preparedStatement = getConnection().prepareStatement(sql);
                preparedStatement.setInt(1,pSeats);
                preparedStatement.setInt(2,obj.getFlightId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(obj.getClassOf().equals("First Class")){

            pSeats=getFirstClasseats(obj.getFlightId());
            pSeats=pSeats-obj.getAdults()-obj.getChildren();

            String sql = "UPDATE flight SET fcSeats=? where flightId=?";
            try {

                preparedStatement = getConnection().prepareStatement(sql);
                preparedStatement.setInt(1,pSeats);
                preparedStatement.setInt(2,obj.getFlightId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else {
            pSeats=getBusinessClassSeats(obj.getFlightId());
            pSeats=pSeats-obj.getAdults()-obj.getChildren();

            String sql = "UPDATE flight SET bcSeats=? where flightId=?";
            try {

                preparedStatement = getConnection().prepareStatement(sql);
                preparedStatement.setInt(1,pSeats);
                preparedStatement.setInt(2,obj.getFlightId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
    public List<flight> getAdminAddedFlights(){

        List<flight> flightList =new ArrayList<flight>();
       PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM flight where approved=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"N");
            //ResultSet flights = preparedStatement.executeQuery();
            //Statement statement = getConnection().createStatement();
            //ResultSet flights=statement.executeQuery("SELECT * FROM flight");

            ResultSet flights=preparedStatement.executeQuery();
        while(flights.next())
        {
            int flightId=flights.getInt("flightId");
            String number= flights.getString("fnumber");
            String approved= flights.getString("approved");
            String from= flights.getString("departure");
            String to= flights.getString("arrival");
            int fcSeats= flights.getInt("fcSeats");
            int fcSeatPrice= flights.getInt("fcSeatPrice");
            int ecSeats= flights.getInt("ecSeats");
            int ecSeatPrice= flights.getInt("ecSeatPrice");
            int bcSeats= flights.getInt("bcSeats");
            int bcSeatPrice= flights.getInt("bcSeatPrice");
            int duration= flights.getInt("duration");
            java.sql.Date date = flights.getDate("fdate");

           // String lastCrawlDate = date.toString();
            //Date utilDate= new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
            Date utilDate=date;

            Time time = flights.getTime("ftime");

            flight f = new flight(flightId,number,utilDate,time,from,to,fcSeats,fcSeatPrice, ecSeats, ecSeatPrice, bcSeats, bcSeatPrice, duration,approved);
            flightList.add(f);
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return flightList;
    }

    public List<flight> getSearchedAddedFlights(String d, String a, String inDate){

        List<flight> flightList =new ArrayList<flight>();
        PreparedStatement preparedStatement = null;

        try {

            Date utilDate1 = null;
            try {
                utilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(inDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate1.getTime());
            String sql = "SELECT * FROM flight where approved=? and departure=? and arrival=? and fdate=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"Y");
            preparedStatement.setString(2,d);
            preparedStatement.setString(3,a);
            preparedStatement.setDate(4,sqlDate);
            //ResultSet flights = preparedStatement.executeQuery();
            //Statement statement = getConnection().createStatement();
            //ResultSet flights=statement.executeQuery("SELECT * FROM flight");

            ResultSet flights=preparedStatement.executeQuery();
            while(flights.next())
            {
                String number= flights.getString("fnumber");
                String approved= flights.getString("approved");
                String from= flights.getString("departure");
                String to= flights.getString("arrival");
                int fcSeats= flights.getInt("fcSeats");
                int fcSeatPrice= flights.getInt("fcSeatPrice");
                int ecSeats= flights.getInt("ecSeats");
                int ecSeatPrice= flights.getInt("ecSeatPrice");
                int bcSeats= flights.getInt("bcSeats");
                int bcSeatPrice= flights.getInt("bcSeatPrice");
                int duration= flights.getInt("duration");
                int flightId= flights.getInt("flightId");
                java.sql.Date date = flights.getDate("fdate");

                // String lastCrawlDate = date.toString();
                //Date utilDate= new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
                Date utilDate=date;

                Time time = flights.getTime("ftime");

                flight f = new flight(flightId,number,utilDate,time,from,to,fcSeats,fcSeatPrice, ecSeats, ecSeatPrice, bcSeats, bcSeatPrice, duration,approved);
                flightList.add(f);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return flightList;
    }

    public List<flight> getManagerPageFlights(){

        List<flight> flightList =new ArrayList<flight>();

        try {
            Statement statement = getConnection().createStatement();

            ResultSet flights=statement.executeQuery("SELECT * FROM flight");
            while(flights.next())
            {
                String number= flights.getString("number");
                String approved= flights.getString("approved");
                String from= flights.getString("from");
                String to= flights.getString("to");
                int fcSeats= flights.getInt("fcSeats");
                int fcSeatPrice= flights.getInt("fcSeatPrice");
                int ecSeats= flights.getInt("ecSeats");
                int ecSeatPrice= flights.getInt("ecSeatPrice");
                int bcSeats= flights.getInt("bcSeats");
                int bcSeatPrice= flights.getInt("bcSeatPrice");
                int duration= flights.getInt("duration");
                java.sql.Date date = flights.getDate("date");

                // String lastCrawlDate = date.toString();
                //Date utilDate= new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
                Date utilDate=date;

                Time time = flights.getTime("time");

                flight f = new flight(number,utilDate,time,from,to,fcSeats,fcSeatPrice, ecSeats, ecSeatPrice, bcSeats, bcSeatPrice, duration,approved);
                flightList.add(f);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return flightList;
    }

    public void updateFlightData(flight f,String knum,Date kdate, Time ktime){

        PreparedStatement preparedStatement = null;
        String sql = "UPDATE flight SET fnumber=?, approved=?,departure=?, arrival=?, fcSeats=?, fcSeatPrice=?, ecSeats=?, ecSeatPrice=?, bcSeats=?, bcSeatPrice=?, duration=?, fdate=?, ftime=?  where flightId=?";
        try {
            java.sql.Date sqlDate = new java.sql.Date(f.getDate().getTime());
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setString(1,f.getFlightNum());
            preparedStatement.setString(2,f.getApproved());
            preparedStatement.setString(3,f.getFrom());
            preparedStatement.setString(4,f.getTo());
            preparedStatement.setInt(5,f.getFcSeats());
            preparedStatement.setInt(6,f.getFcSeatPrice());
            preparedStatement.setInt(7,f.getEcSeats());
            preparedStatement.setInt(8,f.getEcSeatPrice());
            preparedStatement.setInt(9,f.getBcSeats());
            preparedStatement.setInt(10,f.getBcSeatPrice());
            preparedStatement.setInt(11,f.getDuration());
            preparedStatement.setDate(12,sqlDate);
            preparedStatement.setTime(13,f.getTime());
            preparedStatement.setInt(14,f.getFlightId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void managerUpdate(int _id,String appr){

        PreparedStatement preparedStatement = null;
        String sql = "UPDATE flight SET approved=? where flightId=?";
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,appr);
            preparedStatement.setInt(2,_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getEconomySeats(int fId){
        int temp=0;
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM flight where flightId=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,fId);

            ResultSet flights=preparedStatement.executeQuery();
            while (flights.next()) {
                temp=flights.getInt("ecSeats");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public int getBusinessClassSeats(int fId){

        int temp=0;
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM flight where flightId=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,fId);

            ResultSet flights=preparedStatement.executeQuery();
            while (flights.next()) {
                temp=flights.getInt("bcSeats");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public int getFirstClasseats(int fId){
        int temp=0;
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM flight where flightId=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,fId);

            ResultSet flights=preparedStatement.executeQuery();
            while (flights.next()) {
                temp=flights.getInt("fcSeats");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public flight getFlightById(int fId){
        flight f=new flight();
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM flight where flightId=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,fId);

            ResultSet flights=preparedStatement.executeQuery();
            while (flights.next()) {
                String number= flights.getString("fnumber");
                String approved= flights.getString("approved");
                String from= flights.getString("departure");
                String to= flights.getString("arrival");
                int fcSeats= flights.getInt("fcSeats");
                int fcSeatPrice= flights.getInt("fcSeatPrice");
                int ecSeats= flights.getInt("ecSeats");
                int ecSeatPrice= flights.getInt("ecSeatPrice");
                int bcSeats= flights.getInt("bcSeats");
                int bcSeatPrice= flights.getInt("bcSeatPrice");
                int duration= flights.getInt("duration");
                int flightId= flights.getInt("flightId");
                java.sql.Date date = flights.getDate("fdate");

                // String lastCrawlDate = date.toString();
                //Date utilDate= new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
                Date utilDate=date;

                Time time = flights.getTime("ftime");

                f = new flight(flightId,number,utilDate,time,from,to,fcSeats,fcSeatPrice, ecSeats, ecSeatPrice, bcSeats, bcSeatPrice, duration,approved);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

    public User getUserByname(String inName){
        User u=new User();
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM user where userName=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,inName);

            ResultSet users=preparedStatement.executeQuery();
            while (users.next()) {
                String name= users.getString("userName");
                String email= users.getString("_email");
                String passportNo= users.getString("passportNo");
                String cnic= users.getString("cnic");
                String phoneNo= users.getString("phoneNo");
                String addr= users.getString("addr");
                u = new User(name,email,passportNo,cnic,phoneNo,addr);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}
