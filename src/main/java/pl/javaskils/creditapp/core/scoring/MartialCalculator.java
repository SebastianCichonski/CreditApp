package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.PersonalData;

public class MartialCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(MartialCalculator.class);

    public int calculate(PersonalData personalData){
        int martialScoring = personalData.getMartialStatus().getMartialScoring();

        LOG.info("Martial status = " + personalData.getMartialStatus() + ". ( " + martialScoring + ")");

        return martialScoring;
    }
}
