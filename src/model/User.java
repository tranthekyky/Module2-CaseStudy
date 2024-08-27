package model;

import login.Login;

public class User {
    private String name ;
    private Login account ;


    public User( String name, Login account) {
        this.name = name;
        this.account = account;
    }
    public User (String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Login getAccount() {
        return account;
    }

    public void setAccount(Login account) {
        this.account = account;
    }

}


