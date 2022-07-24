package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.SelfEmployed;

public class SelfEmployedScoringCalculator implements PersonCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(SelfEmployedScoringCalculator.class);

    @Override
    public int calculate(SelfEmployed selfEmployed) {
            if(selfEmployed.getYearsSinceFounded() < 2 ){
                LOG.info("Self employment and years since founded is < 2: -200 points");
                return -200;
            }
        LOG.info("Self employment and years since founded is >= 2: 0 points");
        return 0;
    }



}
