package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.CreditApplication;

public class CreditRatingCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(CreditRatingCalculator.class);

    public static double calculateCreditRating(CreditApplication creditApplication){
        double lonRate = 0;

        switch (creditApplication.getPurposeOfLoan().getType()){
            case MORTGAGE:
                lonRate = Constants.MORTGAGE_LOAN_RATE;
                break;
            case PERSONAL_LOAN:
                lonRate = Constants.PERSONAL_LOAN_RATE;
                break;
        }

        double creditRating = (creditApplication.getPerson().sumOfIncome() / creditApplication.getPerson().getPersonalData().getNumOfFamilyDependants())
                * 12 * creditApplication.getPurposeOfLoan().getPeriod() * lonRate;

        LOG.info("Calculated rating: " + creditRating);

        return creditRating;
    }
}
