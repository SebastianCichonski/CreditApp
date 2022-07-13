package pl.javaskils.creditapp.core.scoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskils.creditapp.core.model.Education;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.model.PersonTestFactory;
import pl.javaskils.creditapp.core.model.PersonalData;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EducationCalculatorTest {

    @InjectMocks
    private EducationCalculator cut;

    @Test
    public void educationCalculatorTest_PRIMARY() {
        Person person = PersonTestFactory.create(Education.PRIMARY);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(-100, educationPoints);
    }

    @Test
    public void educationCalculatorTest_NONE() {
        Person person = PersonTestFactory.create(Education.NONE);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(-200, educationPoints);
    }

    @Test
    public void educationCalculatorTest_MIDDLE() {
        Person person = PersonTestFactory.create(Education.MIDDLE);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(0, educationPoints);
    }

    @Test
    public void educationCalculatorTest_TERTIARY() {
        Person person = PersonTestFactory.create(Education.TERTIARY);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(100, educationPoints);
    }

    @Test
    public void educationCalculatorTest_SECONDARY() {
        Person person = PersonTestFactory.create(Education.SECONDARY);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(0, educationPoints);
    }

    @Test
    public void educationCalculatorTest_POST_SECONDARY() {
        Person person = PersonTestFactory.create(Education.POST_SECONDARY);
        int educationPoints = cut.calculate(person.getPersonalData());
        assertEquals(0, educationPoints);
    }


}