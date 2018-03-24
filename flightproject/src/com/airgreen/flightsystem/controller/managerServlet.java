package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.usecaseClasses.flightUC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "managerServlet" , urlPatterns = "/managerServlet")
public class managerServlet extends HttpServlet {
    private DataSource dataSource;
    RequestDispatcher rd;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        int flightId = Integer.parseInt(request.getParameter("flightId"));
        String approved= request.getParameter("approved");

        flightUC flightUCobj=new flightUC(dataSource);
        flightUCobj.managerUpdate(flightId,approved);
        rd =request.getRequestDispatcher("/ManagerPage");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        int flightId = Integer.parseInt(request.getParameter("flightId"));
        String approved= request.getParameter("approved");

        flightUC flightUCobj=new flightUC(dataSource);
        flightUCobj.managerUpdate(flightId,approved);
        rd =request.getRequestDispatcher("/ManagerPage");
        rd.forward(request,response);
    }
}
