package pl.javaskils.creditapp.core;

import org.junit.Test;
import org.junit.runners.Suite;
import org.junit.platform.suite.api.*;
import pl.javaskils.creditapp.core.scoring.ContactDataTest;
import pl.javaskils.creditapp.core.scoring.CreditApplicationServiceBDDTest;
import pl.javaskils.creditapp.core.scoring.CreditApplicationServiceTest;
import pl.javaskils.creditapp.core.scoring.PersonScoringCalculatorTest;

@org.junit.platform.suite.api.Suite
@Suite.SuiteClasses({ContactDataTest.class,
                    CreditApplicationServiceBDDTest.class,
                    CreditApplicationServiceTest.class,
                    PersonScoringCalculatorTest.class})
class TestSuite {

}
