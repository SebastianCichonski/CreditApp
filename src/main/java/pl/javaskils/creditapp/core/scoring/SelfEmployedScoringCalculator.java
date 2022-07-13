package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.SelfEmployed;

public class SelfEmployedScoringCalculator extends PersonScoringCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(SelfEmployedScoringCalculator.class);


    public SelfEmployedScoringCalculator(IncomeCalculator incomeCalculator, MartialCalculator martialCalculator, EducationCalculator educationCalculator, SourceOfIncomeCalculator sourceOfIncomeCalculator) {
        super(incomeCalculator,martialCalculator,educationCalculator,sourceOfIncomeCalculator);
    }

    @Override
    protected int addAdditionalPoints(Person person) {
        if(person instanceof SelfEmployed){
            SelfEmployed selfEmployed = (SelfEmployed) person;
            if(selfEmployed.getYearsSinceFounded() < 2 ){
                LOG.info("Self employment and years since founded is < 2: -200 points");
                return -200;
            }
        }
        LOG.info("Self employment and years since founded is >= 2: 0 points");
        return 0;
    }



}
