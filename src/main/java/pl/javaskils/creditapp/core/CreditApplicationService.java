package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskils.creditapp.core.model.LoanApplication;
import pl.javaskils.creditapp.core.model.Person;

import java.util.UUID;

public class CreditApplicationService {
    private static final Logger LOG = LoggerFactory.getLogger(CreditApplicationService.class);

    private final PersonScoringCalculator calculator;
    //Konstruktor dla testów.
    public CreditApplicationService(PersonScoringCalculator calculator) {
        this.calculator = calculator;
    }

    public CreditApplicationDecision getDecision(LoanApplication loanApplication){
        String id = UUID.randomUUID().toString();
        LOG.info("Application ID is: " + id);
        MDC.put("id",id);

       Person person = loanApplication.getPerson();
       int scoring = calculator.calculateScoring(person);
       double creditRating = CreditRatingCalculator.calculateCreditRating(loanApplication);

       CreditApplicationDecision decision;
       if(scoring < 300){
           decision = new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, loanApplication, creditRating, scoring);
       }
       else if (scoring >= 300 && scoring <= 400) {
           decision = new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, loanApplication, creditRating, scoring);
       }
       else if (scoring > 400 && creditRating >= loanApplication.getPurposeOfLoan().getAmount()){

           decision = new CreditApplicationDecision(DecisionType.POSITIVE, loanApplication, creditRating, scoring);
       }
       else{
           decision = new CreditApplicationDecision(DecisionType.NEGATIVE_CREDIT_RATING, loanApplication, creditRating, scoring);
       }
       LOG.info("Decision = " + decision.getDecisionType());
       return decision;
    }


}

