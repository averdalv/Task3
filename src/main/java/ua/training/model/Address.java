package ua.training.model;

import ua.training.GlobalConst;

public class Address {
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String postalCode, String city, String street, String houseNumber, String apartmentNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address() {

    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getFullAddress() {
        return postalCode+GlobalConst.COLON+city+GlobalConst.COLON+street+GlobalConst.COLON+houseNumber+GlobalConst.COLON+apartmentNumber;
    }
    public String toString() {
        return getFullAddress();
    }
}
