package pl.javaskils.creditapp.core.model;

public class ContactData {
    private String email;
    private String phoneNumber;

    public ContactData(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
