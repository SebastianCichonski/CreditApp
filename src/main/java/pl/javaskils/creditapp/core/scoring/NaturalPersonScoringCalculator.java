package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.Person;

public class NaturalPersonScoringCalculator extends PersonScoringCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(NaturalPersonScoringCalculator.class);


    public NaturalPersonScoringCalculator(IncomeCalculator incomeCalculator, MartialCalculator martialCalculator, EducationCalculator educationCalculator, SourceOfIncomeCalculator sourceOfIncomeCalculator) {
        super(incomeCalculator,martialCalculator,educationCalculator,sourceOfIncomeCalculator);
    }

    @Override
    protected int addAdditionalPoints(Person person) {
        LOG.info("Natural person: 0 points");
        return 0;
    }
}
