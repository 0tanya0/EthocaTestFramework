package com.ethoca.magicmouse.model;

public class PersonalInformation {

    public String getFirstName() { return firstName;  }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String phoneNumber;

    public PersonalInformation(String firstname, String lastname, String password, String phoneNumber) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
