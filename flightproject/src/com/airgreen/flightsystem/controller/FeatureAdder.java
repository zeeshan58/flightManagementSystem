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

@WebServlet(name = "FeatureAdder" , urlPatterns = "/addFeature")
public class FeatureAdder extends HttpServlet {
    private DataSource dataSource;
    RequestDispatcher rd;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        String name= request.getParameter("name");
        String desc= request.getParameter("desc");
        String _class= request.getParameter("class");
        if(_class.equals("Economy"))
        {
            _class="economy";
        }
        else if (_class.equals("First")){
            _class="first";
        }
        else if (_class.equals("Business")){
            _class="business";
        }

        feature fObj= new feature(name,desc,_class);

        featureUC FeatureUCobj= new featureUC(dataSource);
        FeatureUCobj.addFeature(fObj);

        rd =request.getRequestDispatcher("/adminPagepopulater");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
