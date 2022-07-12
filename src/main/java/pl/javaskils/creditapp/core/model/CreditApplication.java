package pl.javaskils.creditapp.core.model;

import java.util.Optional;

public class CreditApplication {
    private final Optional<NaturalPerson> naturalPersonOptional;
    private final Optional<SelfEmployed> selfEmployedOptional;
    private final PurposeOfLoan purposeOfLoan;


    public CreditApplication(NaturalPerson naturalPerson, PurposeOfLoan purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
        this.naturalPersonOptional = Optional.of(naturalPerson);
        this.selfEmployedOptional = Optional.empty();
    }

public CreditApplication(SelfEmployed selfEmployed, PurposeOfLoan purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
        this.naturalPersonOptional = Optional.empty();
        this.selfEmployedOptional = Optional.of(selfEmployed);
    }

    public Optional<NaturalPerson> getNaturalPersonOptional() {
        return naturalPersonOptional;
    }

    public Optional<SelfEmployed> getSelfEmployedOptional() {
        return selfEmployedOptional;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public Person getPerson(){
        if(naturalPersonOptional.isPresent()) {
            return naturalPersonOptional.get();
        }
        return selfEmployedOptional.get();
    }
}
