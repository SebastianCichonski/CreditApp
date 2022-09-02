package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.Person;

public class CompundScoringCalculator implements PersonCalculator{
    private static final Logger LOG = LoggerFactory.getLogger(PersonCalculator.class);
    public final PersonCalculator[] calculators;

    public CompundScoringCalculator(PersonCalculator... calculators) {
        this.calculators = calculators;
    }

    @Override
    public int calculate(CreditApplication creditApplication){
        int scoring = 0;
        for(PersonCalculator calculator: calculators){
            scoring += calculator.calculate(creditApplication);
        }
        LOG.info("Calculated scoring: " + scoring);
        return scoring;
    }

}
