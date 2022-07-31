package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;

public interface Validator {
    void validate(CreditApplication creditApplication) throws ValidationException;
}
