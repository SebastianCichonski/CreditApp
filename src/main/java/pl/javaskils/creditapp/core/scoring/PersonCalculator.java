package pl.javaskils.creditapp.core.scoring;

import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.NaturalPerson;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.SelfEmployed;

public interface PersonCalculator {

    default int calculate(Person person){
        if(person instanceof SelfEmployed) {
            return calculate((SelfEmployed) person);
        } else if (person instanceof NaturalPerson) {
            return calculate((NaturalPerson) person);
        }
        return 0;
    }

    default int calculate(SelfEmployed selfEmployed){
        return 0;
    }

    default int calculate(NaturalPerson naturalPerson){
        return 0;
    }
    default int calculate (CreditApplication creditApplication) {return calculate(creditApplication.getPerson());}
}
