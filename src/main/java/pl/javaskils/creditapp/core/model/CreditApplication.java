package pl.javaskils.creditapp.core.model;

import java.util.Optional;

public class CreditApplication {
    private final Person person;
    private final PurposeOfLoan purposeOfLoan;

    public CreditApplication(Person person, PurposeOfLoan purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
        this.person = person;
    }

    public CreditApplication(NaturalPerson build) {
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public Person getPerson(){
        return person;
    }
}
