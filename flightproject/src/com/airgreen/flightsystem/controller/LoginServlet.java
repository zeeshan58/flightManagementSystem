package com.airgreen.flightsystem.controller;

import com.airgreen.flightsystem.model.entityClasses.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

import static java.io.FileDescriptor.out;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private Connection connection=null;

    private DataSource ds;
    RequestDispatcher rd;

    private PreparedStatement preparedStatement = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String uname = request.getParameter("j_username");
        String upass = request.getParameter("j_password");

        if(uname.equals("admin")&&upass.equals("1234")) {

            rd =request.getRequestDispatcher("/adminPagepopulater");
            rd.forward(request,response);

        }
        else if(uname.equals("manager")&&upass.equals("1234")) {

            rd =request.getRequestDispatcher("/Pagepopulater");
            rd.forward(request,response);

        }

        rd =request.getRequestDispatcher("sign_in.jsp");
        rd.forward(request,response);
/*        try {
            ds = (DataSource) getServletContext().getAttribute("data_source");
            connection = ds.getConnection();
           Statement st= connection.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM flight");
            while(rs.next())
            {
               int num= rs.getInt("flight num");
               System.out.println("flight num is: "+num);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession s=request.getSession();
        s.setMaxInactiveInterval(-1);
        //s.setAttribute("uname",request.getUserPrincipal().getName());

        if (request.isUserInRole("admin")){
            //System.out.println("in loginServelet's doGet-------------------------------------------------");
            s.setAttribute("user",request.getUserPrincipal().getName());
            rd =request.getRequestDispatcher("/adminPagepopulater");
            rd.forward(request,response);
        }
        else if(request.isUserInRole("manager")){
            s.setAttribute("user",request.getUserPrincipal().getName());
            rd =request.getRequestDispatcher("/ManagerPage");
            rd.forward(request,response);

        }
        else if(request.isUserInRole("user")){
            s.setAttribute("user",request.getUserPrincipal().getName());
            rd =request.getRequestDispatcher("home.jsp");
            rd.forward(request,response);

        }

    }
}
