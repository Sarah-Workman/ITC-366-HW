package com.example.hw8_ex2;

public class Friends {

    private int id;
    private String firstName;
    private String lastName;
    private String eMail;

    public Friends(int newId, String newfName, String newlName, String neweMail){
        setID(newId);
        setFristName(newfName);
        setLastname(newlName);
        setEmail(neweMail);
    }

    private void setEmail(String neweMail) {
        eMail = neweMail;
    }

    private void setLastname(String newlName) {
        lastName = newlName;
    }

    private void setFristName(String newfName) {
        firstName = newfName;
    }

    private void setID(int newId) {
        id = newId;
    }
    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return eMail;
    }

    public String toString(){
        return id + " ; " + firstName + " ; " + lastName + " ; " + eMail;
    }
}
