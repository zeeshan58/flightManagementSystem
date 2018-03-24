package com.airgreen.flightsystem.listner;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class httpContextInitializationListner implements ServletContextListener {

    private DataSource ds;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context ctx = new InitialContext();
            Context envcontext = (Context) ctx.lookup("java:comp/env");
            ds = (DataSource) envcontext.lookup("jdbc/airgreendb");
            System.out.println("---------using JDNI lookup got datasource: "+ds);
            sce.getServletContext().setAttribute("data_source",ds);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
