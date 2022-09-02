package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.Constants;
import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.Guarantor;

import java.util.TreeSet;

public class GuarantorValidator implements Validator{
    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        TreeSet<Guarantor> guarantors = creditApplication.getGuarantors();
        for(Guarantor guarantor : guarantors) {
            ValidationUtils.validateNotNull("pesel", guarantor.getPesel());
            ValidationUtils.validatePesel("pesel", guarantor.getPesel(), Constants.PESEL_REGEX);

            ValidationUtils.validateMinValue("age", 1, Integer.MAX_VALUE);
        }
    }
}
