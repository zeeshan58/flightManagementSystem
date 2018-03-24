package com.airgreen.flightsystem.model.daoClasses;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoClass {
    private Connection connection;


    public DaoClass(DataSource ds) {
        try {
            this.connection =(Connection) ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR in DaoClass Constuctor");
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public void closeConn(){

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
