package pl.javaskils.creditapp.core.scoring;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectFiles;
import pl.javaskils.creditapp.core.CreditApplicationDecision;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.DecisionType;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;


public class CreditApplicationServiceBDDTest {

    private NaturalPersonScoringCalculator naturalPersonScoringCalculator =
            new NaturalPersonScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator(), new SourceOfIncomeCalculator());
    private SelfEmployedScoringCalculator selfEmployedScoringCalculator =
            new SelfEmployedScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator(), new SourceOfIncomeCalculator());

    private PersonScoringCalculatorFactory calculator =
            new PersonScoringCalculatorFactory(naturalPersonScoringCalculator,selfEmployedScoringCalculator);

    private CreditApplicationService cut = new CreditApplicationService(calculator);

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create();

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000.00, decision.getCreditRate(), 0.01);
    }
    @Test
    public void test_scoring_calculator_test_when_years_since_founded_less_2_NEGATIVE_SCORING() {
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(1, 500_000.00,
                PurposeOfLoanType.MORTGAGE, (byte) 30, 2, Education.MIDDLE, MartialStatus.MARRIED, 7_000.00);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
        assertEquals(200, decision.getScoring());
    }

    @Test
    public void test_scoring_calculator_test_when_years_since_founded_more_2_NEGATIVE_SCORING() {
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(3, 500_000.00,
                PurposeOfLoanType.MORTGAGE, (byte) 30, 2, Education.MIDDLE, MartialStatus.MARRIED, 7_000.00);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
        assertEquals(400, decision.getScoring());
    }
}