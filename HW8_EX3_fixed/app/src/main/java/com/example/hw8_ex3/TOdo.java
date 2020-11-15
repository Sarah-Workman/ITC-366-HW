package com.example.hw8_ex3;

public class TOdo {
    private int id;
    private String Ntodo;

    public TOdo(int newId, String newTODO){
        setID(newId);
        setNewTODO(newTODO);
        
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
    public String toString(){
        return id + " ; " + Ntodo;
    }
}
