package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;

public class CreditApplicationValidator implements Validator{
    private final PersonValidator personValidator;
    private final PurposeOfLoanValidator purposeOfLoanValidator;
    public CreditApplicationValidator(PersonValidator personValidator, PurposeOfLoanValidator purposeOfLoanValidator) {
        this.personValidator = personValidator;
        this.purposeOfLoanValidator = purposeOfLoanValidator;
    }


    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        ValidationUtils.validateNotNull("person", creditApplication.getPerson());
        personValidator.validate(creditApplication);

        ValidationUtils.validateNotNull("purposeOfLoan", creditApplication.getPurposeOfLoan());
        purposeOfLoanValidator.validate(creditApplication);

    }
}
