package pl.javaskils.creditapp.client;

import pl.javaskils.creditapp.core.model.Education;
import pl.javaskils.creditapp.core.model.IncomeType;
import pl.javaskils.creditapp.core.model.MartialStatus;
import pl.javaskils.creditapp.core.model.PurposeOfLoanType;

public class EnumValidator {
    public static boolean validateMartialStatus(String martialStatusString){
        for(MartialStatus status : MartialStatus.values()){
            if(status.name().equals(martialStatusString)) return true;
        }
        return false;
    }

    public static boolean validateEducation(String educationString){
        for(Education status : Education.values()){
            if(status.name().equals(educationString)) return true;
        }
        return false;
    }

    public static boolean validateIncomeType(String incomeTypeString){
        for(IncomeType status : IncomeType.values()){
            if(status.name().equals(incomeTypeString)) return true;
        }
        return false;
    }

    public static boolean validatePurposeOfLoanType(String purposeOfLoanTypeString){
        for(PurposeOfLoanType status : PurposeOfLoanType.values()){
            if(status.name().equals(purposeOfLoanTypeString)) return true;
        }
        return false;
    }
}
