package com.automationpractice.model;

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

    public Address getAddress() {
        return address;
    }

    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Address address;

    public PersonalInformation(String firstname, String lastname, String password, String phoneNumber) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public PersonalInformation (){

    }

}
