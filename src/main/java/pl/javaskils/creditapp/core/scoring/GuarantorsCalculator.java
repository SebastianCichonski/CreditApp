package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.Guarantor;
import pl.javaskils.creditapp.core.model.Person;

import java.util.Set;
import java.util.TreeSet;

public class GuarantorsCalculator implements PersonCalculator{
    private static final Logger LOG = LoggerFactory.getLogger(GuarantorsCalculator.class);

    @Override
    public int calculate(CreditApplication creditApplication) {
        TreeSet<Guarantor> guarantors = creditApplication.getGuarantors();
        int points1 = 0;
        int points2 = 0;
        for(Guarantor guarantor : guarantors){
           if(guarantor.getAge() < 40) {
                points1 += 50;
           }
           else points2 += 25;
        }
        if(points1 > 0)LOG.info("Points for guarantors < 40: " + points1);
        if(points2 > 0)LOG.info("Points for guarantors >= 40: " + points2);
        return points1 + points2;
    }
}
