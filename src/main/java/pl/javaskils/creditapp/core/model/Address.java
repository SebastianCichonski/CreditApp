package pl.javaskils.creditapp.core.model;

public class Address {
    private final String street;
    private final String city;
    private final String houseNumber;
    private final String zipCode;
    private final String state;

    public Address(String street, String city, String houseNumber, String zipCode, String state) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.state = state;
    }
}
