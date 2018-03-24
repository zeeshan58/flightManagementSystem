package com.airgreen.flightsystem.model.usecaseClasses;

import com.airgreen.flightsystem.model.daoClasses.daoFeature;
import com.airgreen.flightsystem.model.entityClasses.feature;

import javax.sql.DataSource;
import java.util.List;

public class featureUC {
    DataSource dataSource;

    public featureUC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addFeature(feature inF){

        daoFeature daoFeatureObj = new daoFeature(dataSource);
        daoFeatureObj.addfeature(inF);
        daoFeatureObj.closeConn();
    }

    public void updateFeature(feature inF){

        daoFeature daoFeatureObj = new daoFeature(dataSource);
        daoFeatureObj.updateFeature(inF);
        daoFeatureObj.closeConn();
    }

    public void deleteFeature(feature inF){

        daoFeature daoFeatureObj = new daoFeature(dataSource);
        daoFeatureObj.deleteFeature(inF);
        daoFeatureObj.closeConn();
    }

    public List<feature> getEfeatures(){

        daoFeature daoFeatureObj = new daoFeature(dataSource);
        List<feature> l= daoFeatureObj.getEfeatures();

        daoFeatureObj.closeConn();
        return l;
    }
    public List<feature> getFfeatures(){

        daoFeature daoFeatureObj = new daoFeature(dataSource);

        List<feature> l= daoFeatureObj.getFfeatures();
        daoFeatureObj.closeConn();
        return l;
    }
    public List<feature> getBfeatures(){

        daoFeature daoFeatureObj = new daoFeature(dataSource);
        List<feature> l= daoFeatureObj.getBfeatures();
        daoFeatureObj.closeConn();
        return l;
    }
}
