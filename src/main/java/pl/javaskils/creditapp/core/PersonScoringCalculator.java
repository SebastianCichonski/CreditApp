package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.scoring.EducationCalculator;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;
import pl.javaskils.creditapp.core.scoring.MartialCalculator;
import pl.javaskils.creditapp.core.scoring.SourceOfIncomeCalculator;

public abstract class PersonScoringCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(PersonScoringCalculator.class);
    private final IncomeCalculator incomeCalculator;
    private final MartialCalculator martialCalculator;
    private final EducationCalculator educationCalculator;
    private final SourceOfIncomeCalculator sourceOfIncomeCalculator;

    public PersonScoringCalculator(IncomeCalculator incomeCalculator, MartialCalculator martialCalculator, EducationCalculator educationCalculator, SourceOfIncomeCalculator sourceOfIncomeCalculator) {
        this.incomeCalculator = incomeCalculator;
        this.martialCalculator = martialCalculator;
        this.educationCalculator = educationCalculator;
        this.sourceOfIncomeCalculator = sourceOfIncomeCalculator;
    }

    protected abstract int addAdditionalPoints(Person person);

    public int calculateScoring(Person person){
        int income = incomeCalculator.calculate(person);
        int martialScoring = martialCalculator.calculate(person.getPersonalData());
        int educationScoring = educationCalculator.calculate(person.getPersonalData());
        int sourceOfIncomeExtraPoints = sourceOfIncomeCalculator.calculate(person);

        int scoring = income + martialScoring + educationScoring + sourceOfIncomeExtraPoints + addAdditionalPoints(person);

        LOG.info("Calculated scoring: " + scoring);

        return scoring;
    }

}
