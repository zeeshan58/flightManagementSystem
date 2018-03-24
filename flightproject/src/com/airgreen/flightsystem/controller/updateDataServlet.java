package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.entityClasses.flight;
import com.airgreen.flightsystem.model.usecaseClasses.flightUC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "updateDataServlet",urlPatterns = "/updateData")
public class updateDataServlet extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        String number=  request.getParameter("mNumber");
        String from=  request.getParameter("mFrom");
        String to=  request.getParameter("mTo");
        String lastCrawlDate = request.getParameter("mDate");
        Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String time = request.getParameter("mTime");;
        Date dateT = null;
        try {
            dateT = new SimpleDateFormat("HH:mm").parse(time);
        }
        catch (ParseException e) {

        }

        int nbcSeats = Integer.parseInt( request.getParameter("mBcSeats"));
        int nfcSeats = Integer.parseInt( request.getParameter("mFcSeats"));
        int necSeats = Integer.parseInt( request.getParameter("mEcSeats"));
        int fcPrice = Integer.parseInt( request.getParameter("mFcSeatPrice"));
        int ecPrice = Integer.parseInt( request.getParameter("mEcSeatPrice"));
        int bcPrice = Integer.parseInt( request.getParameter("mFcSeatPrice"));
        int duration = Integer.parseInt( request.getParameter("mDuration"));
        int flightId=Integer.parseInt( request.getParameter("flightId"));

        flight f = new flight(flightId,number,utilDate,new Time(dateT.getTime()),from,to,nfcSeats,fcPrice, necSeats, ecPrice, nbcSeats, bcPrice, duration, "N");


        String knumber=  request.getParameter("pFlightNum");
        String klastCrawlDate = request.getParameter("pDate");
        Date kUtilDate = null;
        try {
            kUtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(klastCrawlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String ktime = request.getParameter("pTime");
        Date kdateT = null;
        try {
            kdateT = new SimpleDateFormat("HH:mm").parse(time);
        }
        catch (ParseException e) {

        }



        flightUC flightUCobj=new flightUC(dataSource);

        flightUCobj.updateFilghtData(f,knumber,kUtilDate,new Time(dateT.getTime()));

        RequestDispatcher rd =request.getRequestDispatcher("/adminPagepopulater");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
