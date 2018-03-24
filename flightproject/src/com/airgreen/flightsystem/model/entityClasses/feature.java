package com.airgreen.flightsystem.model.entityClasses;

public class feature {
    int id;
    String name;
    String desc;
    String classOf;

    public feature() {
        name=null;
        desc=null;
    }

    public feature(int id, String name, String desc, String classOf) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.classOf = classOf;
    }

    public feature( String name, String desc, String classOf) {
        this.id = 0;
        this.name = name;
        this.desc = desc;
        this.classOf = classOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getClassOf() {
        return classOf;
    }

    public void setClassOf(String classOf) {
        this.classOf = classOf;
    }
}
