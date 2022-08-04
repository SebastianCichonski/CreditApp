package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.ContactData;
import pl.javaskils.creditapp.core.model.CreditApplication;

public class PersonValidator implements Validator {
    private final PersonalDataValidator personalDataValidator;

    public PersonValidator(PersonalDataValidator personalDataValidator) {
        this.personalDataValidator = personalDataValidator;
    }

    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        ValidationUtils.validateNotNull("personalData", creditApplication.getPerson().getPersonalData());
        ValidationUtils.validateNotNull("contactData", creditApplication.getPerson().getContactData());
        ValidationUtils.validateNotNull("financeData", creditApplication.getPerson().getFinanceData());

        personalDataValidator.validate(creditApplication);
    }
}
