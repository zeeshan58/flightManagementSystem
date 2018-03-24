package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.entityClasses.feature;
import com.airgreen.flightsystem.model.usecaseClasses.featureUC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "deleteFeature" , urlPatterns = "/deleteFeature")
public class deleteFeature extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        String name= request.getParameter("d_name");
        String desc= request.getParameter("d_desc");
        int id= Integer.parseInt(request.getParameter("d_id"));

        feature fObj= new feature(id,name,desc,"default");

        featureUC FeatureUCobj= new featureUC(dataSource);
        FeatureUCobj.deleteFeature(fObj);

        RequestDispatcher rd =request.getRequestDispatcher("/adminPagepopulater");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
