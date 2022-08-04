package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.PurposeOfLoan;

public class PurposeOfLoanValidator implements Validator{
    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        PurposeOfLoan purposeOfLoan = creditApplication.getPurposeOfLoan();
        ValidationUtils.validateNotNull("purposeOfLoanType", purposeOfLoan.getType());
        ValidationUtils.validateMinValue("amount", 0.0, purposeOfLoan.getAmount());

    }
}
