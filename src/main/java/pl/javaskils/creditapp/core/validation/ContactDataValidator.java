package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.Constants;
import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.ContactData;
import pl.javaskils.creditapp.core.model.CreditApplication;

public class ContactDataValidator implements Validator{
    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        ContactData contactData = creditApplication.getPerson().getContactData();

        ValidationUtils.validateNotNull("email", contactData.getEmail());
        ValidationUtils.validateRegex("email", contactData.getEmail(), Constants.EMAIL_REGEX);

        ValidationUtils.validateNotNull("phoneNumber", contactData.getPhoneNumber());
        ValidationUtils.validateRegex("phoneNumber", contactData.getPhoneNumber(), Constants.PHONE_REGEX);

        ValidationUtils.validateNotNull("correspondenceAddress", contactData.getCorrespondenceAddress());
        ValidationUtils.validateNotNull("address", contactData.getHomeAddress());
    }
}
