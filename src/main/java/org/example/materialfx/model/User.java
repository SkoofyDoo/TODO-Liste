package org.example.materialfx.model;

public class User {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String gender;
    private int userid;

    public User() {
    }

    public User(String firstname, String lastname, String username, String password, String gender) {
        this.gender = gender;
        this.password = password;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public User(int userid){
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
