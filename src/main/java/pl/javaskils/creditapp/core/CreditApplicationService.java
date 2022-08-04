package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskils.creditapp.core.exception.*;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.scoring.PersonScoringCalculatorFactory;
import pl.javaskils.creditapp.core.validation.CreditApplicationValidator;

import java.util.UUID;

public class CreditApplicationService {
    private static final Logger LOG = LoggerFactory.getLogger(CreditApplicationService.class);
    private final PersonScoringCalculatorFactory personScoringCalculatorFactory;
    private final CreditApplicationValidator creditApplicationValidator;

    //Konstruktor dla testów.
    public CreditApplicationService(PersonScoringCalculatorFactory personScoringCalculatorFactory, CreditApplicationValidator creditApplicationValidator) {
        this.personScoringCalculatorFactory = personScoringCalculatorFactory;
        this.creditApplicationValidator = creditApplicationValidator;
    }

    public CreditApplicationDecision getDecision(CreditApplication creditApplication){
        String id = UUID.randomUUID().toString();
        LOG.info("Application ID is: " + id);
        MDC.put("id",id);

        try {
            creditApplicationValidator.validate(creditApplication);
            Person person = creditApplication.getPerson();

            int scoring = personScoringCalculatorFactory.getCalculator(person).calculate(person);

            double creditRating = CreditRatingCalculator.calculateCreditRating(creditApplication);

            CreditApplicationDecision decision;
            if (scoring < 300) {
                decision = new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, creditApplication, creditRating, scoring);
            } else if (scoring >= 300 && scoring <= 400) {
                decision = new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, creditApplication, creditRating, scoring);
            } else if (scoring > 400 && creditRating >= creditApplication.getPurposeOfLoan().getAmount()) {
                if (creditApplication.getPurposeOfLoan().getAmount() < Constants.MIN_LOAN_AMOUNT_MORTGAGE) {
                    decision = new CreditApplicationDecision(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, creditApplication, creditRating, scoring);
                } else {
                    decision = new CreditApplicationDecision(DecisionType.POSITIVE, creditApplication, creditRating, scoring);
                }
            } else {
                decision = new CreditApplicationDecision(DecisionType.NEGATIVE_CREDIT_RATING, creditApplication, creditRating, scoring);
            }
            LOG.info("Decision = " + decision.getDecisionType());
            return decision;
        }catch (ValidationException validationException){
            LOG.error(validationException.getMessage());
            throw new IllegalStateException();
        }catch (Exception exception){
            LOG.error(exception.getMessage());
            throw new IllegalStateException();
        }finally {
            LOG.info("Application processing id finished.");
        }
    }


}

