package com.ethoca.magicmouse.model;

public class Address {

    private final String addressLine;
    private final String city;
    private final String state;
    private final String code;
    private final String country;

    public Address(String addressLine, String city, String state, String code, String country) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
    }
    public String getAddressLine() {
        return addressLine;
    }

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
