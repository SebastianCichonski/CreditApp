package pl.javaskils.creditapp.core.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        Address address = (Address) o;
        return street.equals(address.street) &&
                city.equals(address.city) &&
                houseNumber.equals(address.houseNumber) &&
                zipCode.equals(address.zipCode) &&
                state.equals(address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, houseNumber, zipCode, state);
    }
}
