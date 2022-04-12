package com.unicon.ipms;

public class myIntenshipDateModel {
    String company_name;
    String start_date;
    String end_date;
    public myIntenshipDateModel(){

    }
    public myIntenshipDateModel(String company_name,String start_date,String end_date){
        this.company_name = company_name;
        this.end_date = end_date;
        this.start_date = start_date;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }
    public String getStart_date(){
        return start_date;
    }
    public String getEnd_date(){
        return end_date;
    }
    public  String getCompany_name(){
        return company_name;
    }
}
