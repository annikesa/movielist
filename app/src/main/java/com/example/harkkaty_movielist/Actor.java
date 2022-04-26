package com.example.harkkaty_movielist;

public class Actor {
    String name;
    String firstname;
    String lastname;


    public Actor ( String name, String firstname, String lastname) {

        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public String getMovName() {
        return name;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }
}
