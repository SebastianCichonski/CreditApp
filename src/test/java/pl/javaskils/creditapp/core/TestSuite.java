package pl.javaskils.creditapp.core;

//import org.junit.runners.Suite;
import org.junit.platform.suite.api.*;
import pl.javaskils.creditapp.core.model.AddressTest;
import pl.javaskils.creditapp.core.model.CreditApplicationTest;
import pl.javaskils.creditapp.core.model.PersonTest;
import pl.javaskils.creditapp.core.scoring.*;

@Suite
@SelectClasses({ContactDataTest.class,
        CreditApplicationServiceBDDTest.class,
        CreditApplicationServiceTest.class,
        CompundScoringCalculatorTest.class,
        AddressTest.class,
        CreditApplicationTest.class,
        EducationCalculatorTest.class,
        GuarantorsCalculatorTest.class,
        PersonTest.class})
public class TestSuite {

}
