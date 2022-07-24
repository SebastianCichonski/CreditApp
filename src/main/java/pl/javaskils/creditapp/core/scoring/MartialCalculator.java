package pl.javaskils.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.PersonalData;

public class MartialCalculator implements PersonCalculator{

    private static final Logger LOG = LoggerFactory.getLogger(MartialCalculator.class);

    public int calculate(Person person){
        int martialScoring = person.getPersonalData().getMartialStatus().getMartialScoring();

        LOG.info("Martial status = " + person.getPersonalData().getMartialStatus() + ". ( " + martialScoring + ")");

        return martialScoring;
    }
}
