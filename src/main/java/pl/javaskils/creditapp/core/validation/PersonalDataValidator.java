package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.Constants;
import pl.javaskils.creditapp.core.exception.ValidationException;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.PersonalData;

import static pl.javaskils.creditapp.core.Constants.*;

public class PersonalDataValidator implements Validator{
    @Override
    public void validate(CreditApplication creditApplication) throws ValidationException {
        PersonalData personalData = creditApplication.getPerson().getPersonalData();

        ValidationUtils.validateNotNull("lastName", personalData.getLastName());
        ValidationUtils.validateRegex("lastName", personalData.getLastName(), LAST_NAME_REGEX);

        ValidationUtils.validateNotNull("name", personalData.getName());
        ValidationUtils.validateRegex("name", personalData.getName(), NAME_REGEX);

        ValidationUtils.validateNotNull("mothersMaidenName", personalData.getMothersMaidenName());
        ValidationUtils.validateRegex("mothersMaidenName", personalData.getMothersMaidenName(), LAST_NAME_REGEX);

        ValidationUtils.validateNotNull("education", personalData.getEducation());
        ValidationUtils.validateNotNull("maritalStatus", personalData.getMartialStatus());

        ValidationUtils.validateMinValue("numOfDependants", 0, personalData.getNumOfFamilyDependants());

    }
}
