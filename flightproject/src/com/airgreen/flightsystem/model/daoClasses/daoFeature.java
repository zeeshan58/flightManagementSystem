package com.airgreen.flightsystem.model.daoClasses;

import com.airgreen.flightsystem.model.entityClasses.feature;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoFeature extends DaoClass {
    public daoFeature(DataSource ds) {
        super(ds);
    }

    public void addfeature(feature f){

        try {

            String sql = "INSERT INTO flightpro.features VALUES (?, ?, ?, ?)";


            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, f.getName());
            preparedStatement.setString(3, f.getDesc());
            preparedStatement.setString(4, f.getClassOf());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Issue in addFeature of daoFeature while interacting with db");
        }


    }

    public void updateFeature(feature f){

        PreparedStatement preparedStatement = null;
        String sql = "UPDATE features SET fname=?, fdesc=?, classOf=? where fid=?";
        try {

            preparedStatement = getConnection().prepareStatement(sql);
            //preparedStatement.setInt(1,0);
            preparedStatement.setString(1,f.getName());
            preparedStatement.setString(2,f.getDesc());
            preparedStatement.setString(3,f.getClassOf());

            preparedStatement.setInt(4,f.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteFeature(feature f){

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM features where fid=?";
        try {

            preparedStatement = getConnection().prepareStatement(sql);
            //preparedStatement.setInt(1,0);
            //preparedStatement.setString(1,f.getName());
            //preparedStatement.setString(2,f.getDesc());
            //preparedStatement.setString(3,f.getClassOf());

            preparedStatement.setInt(1,f.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<feature> getEfeatures(){
        List<feature> featureList = new ArrayList<feature>();
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM features where classOF=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"economy");

            ResultSet features=preparedStatement.executeQuery();
            while(features.next())
            {
                String name= features.getString("fname");
                String desc= features.getString("fdesc");
                String classOf= features.getString("classOf");
                int id= features.getInt("fid");


                feature f = new feature(id,name,desc,classOf);
                featureList.add(f);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return featureList;

    }
    public List<feature> getFfeatures(){
        List<feature> featureList = new ArrayList<feature>();
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM features where classOF=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"first");

            ResultSet features=preparedStatement.executeQuery();
            while(features.next())
            {
                String name= features.getString("fname");
                String desc= features.getString("fdesc");
                String classOf= features.getString("classOf");
                int id= features.getInt("fid");


                feature f = new feature(id,name,desc,classOf);
                featureList.add(f);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return featureList;

    }
    public List<feature> getBfeatures(){
        List<feature> featureList = new ArrayList<feature>();
        PreparedStatement preparedStatement = null;

        try {


            String sql = "SELECT * FROM features where classOF=?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"business");

            ResultSet features=preparedStatement.executeQuery();
            while(features.next())
            {
                String name= features.getString("fname");
                String desc= features.getString("fdesc");
                String classOf= features.getString("classOf");
                int id= features.getInt("fid");


                feature f = new feature(id,name,desc,classOf);
                featureList.add(f);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return featureList;

    }
}
