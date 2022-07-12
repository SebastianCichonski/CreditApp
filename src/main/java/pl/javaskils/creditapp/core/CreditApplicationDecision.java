package pl.javaskils.creditapp.core;

import pl.javaskils.creditapp.core.model.CreditApplication;

public class CreditApplicationDecision {
    private final DecisionType decisionType;
    private final CreditApplication loanApplication;
    private  final Double creditRate;
    private final int scoring;

    public CreditApplicationDecision(DecisionType decisionType, CreditApplication loanApplication, Double creditRate, int scoring) {
        this.decisionType = decisionType;
        this.loanApplication = loanApplication;
        this.creditRate = creditRate;
        this.scoring = scoring;
    }

    public String getDecision(){
        switch (decisionType) {
            case POSITIVE:
                return "Congratulation, " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() +
                        ", decision is positive";
            case NEGATIVE_CREDIT_RATING:
                return "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() +
                        ", decision is negative.";
            case NEGATIVE_SCORING:
                return "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() +
                        ", decision is negative. Bank can borrow only " + creditRate + ".";
            case CONTACT_REQUIRED:
                return "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() +
                        ", bank require additional documents. Our Consultant will contact you.";
        }
        return null;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

    public Double getCreditRate() {
        return creditRate;
    }

    public int getScoring() {
        return scoring;
    }
}
