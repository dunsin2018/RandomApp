package com.example.randomapp;

public class FireBaseRecordModel
{



    public   FireBaseRecordModel()
    {
        Long  timeStamp = System.currentTimeMillis()/1000;
        setTimeStamp(timeStamp.toString());
    }
    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    private  String equation;


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private  String timeStamp;

}
