package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.EmailUtility;
import com.airgreen.flightsystem.model.entityClasses.User;
import com.airgreen.flightsystem.model.entityClasses.booking;
import com.airgreen.flightsystem.model.entityClasses.flight;
import com.airgreen.flightsystem.model.usecaseClasses.flightUC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "confirmFlight" , urlPatterns = "/confirmFlight")
public class confirmFlight extends HttpServlet {
    private DataSource dataSource;
    private String host;
    private String port;
    private String user;
    private String pass;
    private String res;

    @Override
    public void init() throws ServletException {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        res = context.getInitParameter("res");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dataSource = (DataSource) getServletContext().getAttribute("data_source");
        String userName=request.getUserPrincipal().getName();
        //String userName= (String) request.getSession().getAttribute("uname");
        int flightId= Integer.parseInt( request.getParameter("flightId"));
        String classOf= request.getParameter("classOf");
        int adults= Integer.parseInt( request.getParameter("adults"));
        int infants= Integer.parseInt( request.getParameter("infants"));
        int children= Integer.parseInt( request.getParameter("children"));
        int price= Integer.parseInt( request.getParameter("price"));

        booking b=new booking(0,userName,flightId,classOf,adults,infants,children,price);

        flightUC flightUCObj= new flightUC(dataSource);
        User u=flightUCObj.getUserByname(b);
        flight f=flightUCObj.getFlightById(b);


        String recipient=u.getEmail();
        //String recipient="zeeshanshahid5858@gmail.com";
        String subject="Air Green:Seat booking confirmation";
        String content="Dear Customer Your flight has been booked successfully."+" \n"
                +"your seat booking details are as follows \n"
                +"Flight Num :" +f.getFlightNum()+" \n"
                +"From :" +f.getFrom()+" \n"
                +"To :" +f.getTo()+" \n"
                +"departureDate:" +f.getDate()+" \n"
                +"departureTime(24-h format) :" +f.getTime()+" \n"
                +"adults: " +b.getAdults()+" \n"
                +"children :" +b.getChildren()+" \n"
                +"infants :" +b.getInfants()+" \n"
                +"class:" +b.getClassOf()+"\n"
                +"total price :" +b.getPrice()*b.getAdults()+b.getPrice()*b.getChildren()+" \n"
                ;
        String resultMessage = "";
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);

            RequestDispatcher rd =request.getRequestDispatcher("home.jsp");
            rd.forward(request,response);

        }
        catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
