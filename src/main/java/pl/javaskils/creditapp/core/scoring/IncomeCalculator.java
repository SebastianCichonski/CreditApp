package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.Person;

public class IncomeCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(IncomeCalculator.class);

    public int calculate(Person person){
        double incomPerFamilyMember = person.sumOfIncome() / person.getPersonalData().getNumOfFamilyDependants();
        int pointsOfIncome = (int) ( incomPerFamilyMember / 1000) * 100;

        String points = pointsOfIncome > 0 ? "(+" + pointsOfIncome + " points)" : "(" + pointsOfIncome + " points)";
        LOG.info("Income for family member " + incomPerFamilyMember + ". ( " + points + " )");

        return pointsOfIncome;
    }
}
