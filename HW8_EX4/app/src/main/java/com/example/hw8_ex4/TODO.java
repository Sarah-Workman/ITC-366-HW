package com.example.hw8_ex4;

public class TODO {
    private int id;
    private String Ntodo;
    private String time;
    private String date;

    public TODO(int newId, String newTODO, String newTime, String newDate){
        setID(newId);
        setNewTODO(newTODO);
        setTime(newTime);
        setDate(newDate);

    }



    private void setDate(String newDate) {
        date = newDate;
    }

    private void setTime(String newTime) {
        time = newTime;
    }

    private void setNewTODO(String newTODO) {
        Ntodo = newTODO;
    }

    private void setID(int newId) {
        id = newId;
    }

    public String getTODO() {
        return Ntodo;
    }

    public int getId() {
        return id;
    }
    public String getTime(){
        return time;
    }
    public String getDate(){
        return date;
    }

    public String toString(){
        return id + " , " + Ntodo + " , " + date + " , " + time;
    }
    public String ListView(){
        return Ntodo + " , " + date + " , " + time;}
}
