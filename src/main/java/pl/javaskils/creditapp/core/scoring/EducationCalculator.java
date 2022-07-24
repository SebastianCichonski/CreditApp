package pl.javaskils.creditapp.core.scoring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.PersonalData;

public class EducationCalculator implements PersonCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(EducationCalculator.class);

    @Override
    public int calculate(Person person){
        int educationScoring = person.getPersonalData().getEducation().getEducationScoring();

        LOG.info("Education: " + person.getPersonalData().getEducation() + ". ( " + educationScoring + " )");

        return educationScoring;
    }
}
