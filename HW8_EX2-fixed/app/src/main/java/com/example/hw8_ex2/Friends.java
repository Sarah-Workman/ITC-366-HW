package com.example.hw8_ex2;

public class Friends {

    private int id;
    private String Name;
    private String eMail;

    public Friends(int newId, String newName,  String neweMail){
        setID(newId);
        setName(newName);
        setEmail(neweMail);
    }

    private void setEmail(String neweMail) {
        eMail = neweMail;
    }

    private void setName(String newName) {
        Name = newName;
    }

    private void setID(int newId) {
        id = newId;

    }
    public int getId(){
        return id;
    }

    public String getName() {
        return Name;
    }



    public String getEmail() {
        return eMail;
    }

    public String toString(){
        return id + " ; " + Name + " ; " + eMail;
    }
}
