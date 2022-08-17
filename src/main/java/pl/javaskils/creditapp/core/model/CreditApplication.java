package pl.javaskils.creditapp.core.model;

import java.util.Optional;
import java.util.UUID;

public class CreditApplication {
    private final UUID id;
    private final Person person;
    private final PurposeOfLoan purposeOfLoan;

    public CreditApplication(Person person, PurposeOfLoan purposeOfLoan) {
        id = UUID.randomUUID();
        this.purposeOfLoan = purposeOfLoan;
        this.person = person;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public Person getPerson(){
        return person;
    }

    public UUID getId() {
        return id;
    }
}
