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
import java.util.List;

@WebServlet(name = "ManagerPagePopulater",urlPatterns = "/ManagerPage")
public class ManagerPagePopulater extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");
        flightUC flightUCobj=new flightUC(dataSource);

        List<flight> flightList= flightUCobj.getAdminFlightList();
        request.setAttribute("flightList",flightList);


        RequestDispatcher rd =request.getRequestDispatcher("manager.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dataSource = (DataSource) getServletContext().getAttribute("data_source");
        flightUC flightUCobj=new flightUC(dataSource);

        List<flight> flightList= flightUCobj.getAdminFlightList();
        request.setAttribute("flightList",flightList);


        RequestDispatcher rd =request.getRequestDispatcher("manager.jsp");
        rd.forward(request,response);
    }
}
