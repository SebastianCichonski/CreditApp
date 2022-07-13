package pl.javaskils.creditapp.core;

import org.junit.Test;
//import org.junit.runners.Suite;
import org.junit.platform.suite.api.*;
import pl.javaskils.creditapp.core.model.AddressTest;
import pl.javaskils.creditapp.core.model.CreditApplicationTest;
import pl.javaskils.creditapp.core.model.Education;
import pl.javaskils.creditapp.core.scoring.*;

@Suite
@SelectClasses({ContactDataTest.class,
        CreditApplicationServiceBDDTest.class,
        CreditApplicationServiceTest.class,
        PersonScoringCalculatorTest.class,
        AddressTest.class,
        CreditApplicationTest.class,
        EducationCalculatorTest.class})
public class TestSuite {

}
