package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.Person;

public class SourceOfIncomeCalculator implements PersonCalculator{
    private static final Logger LOG = LoggerFactory.getLogger(SourceOfIncomeCalculator.class);

    public int calculate(Person person){
        int sourceOfIncomeExtraPoints;
        if(person.getFinanceData().getSourceOfIncomes().length>1){
            sourceOfIncomeExtraPoints = 100;
        }
        else sourceOfIncomeExtraPoints = 0;

        LOG.info("Extra points for source of income: " + sourceOfIncomeExtraPoints);

        return sourceOfIncomeExtraPoints;
    }
}
