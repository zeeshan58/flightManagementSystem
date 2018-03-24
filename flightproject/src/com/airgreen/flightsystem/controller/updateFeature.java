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

@WebServlet(name = "updateFeature" , urlPatterns = "/updateFeature")
public class updateFeature extends HttpServlet {
    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dataSource = (DataSource) getServletContext().getAttribute("data_source");

        String name= request.getParameter("featureName");
        String desc= request.getParameter("desc");
        int id= Integer.parseInt(request.getParameter("_id"));
        String _class= request.getParameter("class1");
        if(_class.equals("Economy"))
        {
            _class="economy";
        }
        else if (_class.equals("First")){
            _class="first";
        }
        else{
            _class = "business";
        }

        feature fObj= new feature(id,name,desc,_class);

        featureUC FeatureUCobj= new featureUC(dataSource);
        FeatureUCobj.updateFeature(fObj);

        RequestDispatcher rd =request.getRequestDispatcher("/adminPagepopulater");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
