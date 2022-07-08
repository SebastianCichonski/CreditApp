package pl.javaskils.creditapp.core.model;

import java.util.Optional;

public class ContactData {
    private String email;
    private String phoneNumber;
    private Optional<Address> correspondenceAddress;
    private Address homeAddress;

    public ContactData(String email, String phoneNumber, Optional<Address> correspondenceAddress, Address homeAddress) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.correspondenceAddress = correspondenceAddress;
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
