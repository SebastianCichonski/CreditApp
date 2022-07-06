package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.LoanApplication;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.scoring.EducationCalculator;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;
import pl.javaskils.creditapp.core.scoring.MartialCalculator;

public class PersonScoringCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(PersonScoringCalculator.class);
    private final IncomeCalculator incomeCalculator;
    private final MartialCalculator martialCalculator;
    private final EducationCalculator educationCalculator;

    public PersonScoringCalculator(IncomeCalculator incomeCalculator, MartialCalculator martialCalculator, EducationCalculator educationCalculator) {
        this.incomeCalculator = incomeCalculator;
        this.martialCalculator = martialCalculator;
        this.educationCalculator = educationCalculator;
    }

    public int calculateScoring(Person person){
        int income = incomeCalculator.calculate(person);
        int martialScoring = martialCalculator.calculate(person.getPersonalData());
        int educationScoring = educationCalculator.calculate(person.getPersonalData());
        int sourceOfIncomeExtraPoints = 0;

        if(person.getFinanceData().getSourceOfIncomes().length>1){
            sourceOfIncomeExtraPoints = 100;
        }
        int scoring = income + martialScoring + educationScoring + sourceOfIncomeExtraPoints;

        LOG.info("Extra points for source of income: " + sourceOfIncomeExtraPoints);
        LOG.info("Calculated scoring: " + scoring);

        return scoring;
    }

}
