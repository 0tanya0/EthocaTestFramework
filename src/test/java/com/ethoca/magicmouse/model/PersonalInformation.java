package com.ethoca.magicmouse.model;

public class PersonalInformation {

    public String getFirstname() { return firstname;  }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private final String firstname;
    private final String lastname;
    private final String password;
    private final String phoneNumber;

    public PersonalInformation(String firstname, String lastname, String password, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
