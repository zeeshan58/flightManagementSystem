package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.entityClasses.feature;
import com.airgreen.flightsystem.model.entityClasses.flight;
import com.airgreen.flightsystem.model.usecaseClasses.featureUC;
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

@WebServlet(name = "AdminPagePopulater" , urlPatterns = "/adminPagepopulater")
public class AdminPagePopulater extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");
        flightUC flightUCobj=new flightUC(dataSource);
        featureUC featureUCobj = new featureUC(dataSource);

        List<flight> flightList= flightUCobj.getAdminFlightList();
        request.setAttribute("flightList",flightList);

        List<feature> economyFeatures = featureUCobj.getEfeatures();
        request.setAttribute("economyFeatures",economyFeatures);
        List<feature> firstFeatures = featureUCobj.getFfeatures();
        request.setAttribute("firstFeatures",firstFeatures);

        List<feature> businessFeatures = featureUCobj.getBfeatures();
        request.setAttribute("businessFeatures",businessFeatures);
        RequestDispatcher rd =request.getRequestDispatcher("admin.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");
        flightUC flightUCobj=new flightUC(dataSource);
        featureUC featureUCobj = new featureUC(dataSource);

        List<flight> flightList= flightUCobj.getAdminFlightList();
        request.setAttribute("flightList",flightList);

        List<feature> economyFeatures = featureUCobj.getEfeatures();
        request.setAttribute("economyFeatures",economyFeatures);

        List<feature> firstFeatures = featureUCobj.getFfeatures();
        request.setAttribute("firstFeatures",firstFeatures);

        List<feature> businessFeatures = featureUCobj.getBfeatures();
        request.setAttribute("businessFeatures",businessFeatures);

        RequestDispatcher rd =request.getRequestDispatcher("admin.jsp");
        rd.forward(request,response);

    }
}
