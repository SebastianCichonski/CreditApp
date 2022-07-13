package pl.javaskils.creditapp.core.scoring;

import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.NaturalPerson;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.SelfEmployed;

public class PersonScoringCalculatorFactory {
    private final NaturalPersonScoringCalculator naturalPersonScoringCalculator;
    private final SelfEmployedScoringCalculator selfEmployedScoringCalculator;

    public PersonScoringCalculatorFactory(NaturalPersonScoringCalculator naturalPersonScoringCalculator, SelfEmployedScoringCalculator selfEmployedScoringCalculator) {
        this.naturalPersonScoringCalculator = naturalPersonScoringCalculator;
        this.selfEmployedScoringCalculator = selfEmployedScoringCalculator;
    }

    public PersonScoringCalculator getCalculator(Person person){
        if(person instanceof NaturalPerson){
            return naturalPersonScoringCalculator;
        } else if (person instanceof SelfEmployed) {
            return selfEmployedScoringCalculator;
        }
        return null;
        //TODO zrzucić wyjatek!!
    }
}
