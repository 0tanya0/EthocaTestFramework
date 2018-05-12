package com.automationpractice.model;

public class Address {

    private String addressLine;
    private String city;
    private String state;
    private String code;
    private String country;

    public Address() {

    }

    public Address(String addressLine, String city, String state, String code, String country) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
    }
    public String getAddressLine() { return addressLine; }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }


}
