package pl.javaskils.creditapp.core.scoring;

import pl.javaskils.creditapp.core.model.NaturalPerson;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.SelfEmployed;

public class PersonScoringCalculatorFactory {
    private final SelfEmployedScoringCalculator selfEmployedScoringCalculator;
    private final EducationCalculator educationCalculator;
    private final MartialCalculator martialCalculator;
    private final IncomeCalculator incomeCalculator;
    private final SourceOfIncomeCalculator sourceOfIncomeCalculator;

    public PersonScoringCalculatorFactory(SelfEmployedScoringCalculator selfEmployedScoringCalculator, EducationCalculator educationCalculator, MartialCalculator martialCalculator, IncomeCalculator incomeCalculator, SourceOfIncomeCalculator sourceOfIncomeCalculator) {
        this.selfEmployedScoringCalculator = selfEmployedScoringCalculator;
        this.educationCalculator = educationCalculator;
        this.martialCalculator = martialCalculator;
        this.incomeCalculator = incomeCalculator;
        this.sourceOfIncomeCalculator = sourceOfIncomeCalculator;
    }


    public PersonCalculator getCalculator(Person person){
        if(person instanceof NaturalPerson){
            return new CompundScoringCalculator(sourceOfIncomeCalculator,educationCalculator,martialCalculator,incomeCalculator);
        } else if (person instanceof SelfEmployed) {
            return new CompundScoringCalculator(sourceOfIncomeCalculator,educationCalculator,martialCalculator,incomeCalculator,selfEmployedScoringCalculator);
        }
        return null;
        //TODO zrzucić wyjatek!!
    }
}
