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

@WebServlet(name = "flightServlet",urlPatterns = "/flightServlet")
public class flightServlet extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        String number=  request.getParameter("number");
        String from=  request.getParameter("from");
        String to=  request.getParameter("to");
        String lastCrawlDate = request.getParameter("date");
        Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
/*// because PreparedStatement#setDate(..) expects a java.sql.Date argument
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/

        String time = request.getParameter("time");;
        Date dateT = null;
        try {
            dateT = new SimpleDateFormat("HH:mm").parse(time);
        }
        catch (ParseException e) {

        }

        int nbcSeats = Integer.parseInt( request.getParameter("nbcSeats"));
        int nfcSeats = Integer.parseInt( request.getParameter("nfcSeats"));
        int necSeats = Integer.parseInt( request.getParameter("necSeats"));
        int fcPrice = Integer.parseInt( request.getParameter("fcPrice"));
        int ecPrice = Integer.parseInt( request.getParameter("ecPrice"));
        int bcPrice = Integer.parseInt( request.getParameter("bcPrice"));
        int duration = Integer.parseInt( request.getParameter("duration"));

        flight f = new flight(number,utilDate,new Time(dateT.getTime()),from,to,nfcSeats,fcPrice, necSeats, ecPrice, nbcSeats, bcPrice, duration, "N");

        flightUC flightUCobj=new flightUC(dataSource,f);
        flightUCobj.addFlight();

        RequestDispatcher rd =request.getRequestDispatcher("/adminPagepopulater");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
