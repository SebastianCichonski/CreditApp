package pl.javaskils.creditapp.core.scoring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.PersonalData;

public class EducationCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(EducationCalculator.class);

    public int calculate(PersonalData personalData){
        int educationScoring = personalData.getEducation().getEducationScoring();

        LOG.info("Education: " + personalData.getEducation() + ". ( " + educationScoring + " )");

        return educationScoring;
    }
}
