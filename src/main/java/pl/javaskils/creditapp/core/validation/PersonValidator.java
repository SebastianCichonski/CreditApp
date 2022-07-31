package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;

public class PersonValidator implements Validator{
    private final PersonalDataValidator personalDataValidator;

    public PersonValidator(PersonalDataValidator personalDataValidator){
        this.personalDataValidator = personalDataValidator;
    }

    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        ValidationUtils.validateNotNull("personalData", creditApplication.getPerson().getPersonalData());
        personalDataValidator.validate(creditApplication);
        //TODO - ContactData and FinanceData validate.
    }
}
