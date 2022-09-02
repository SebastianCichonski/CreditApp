package pl.javaskils.creditapp.core.scoring;

import org.junit.jupiter.api.Test;
import pl.javaskils.creditapp.core.CreditApplicationDecision;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.DecisionType;
import pl.javaskils.creditapp.core.model.*;
import pl.javaskils.creditapp.core.validation.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;


public class CreditApplicationServiceBDDTest {

    private EducationCalculator educationCalculator = new EducationCalculator();
    private MartialCalculator martialCalculator = new MartialCalculator();
    private IncomeCalculator incomeCalculator = new IncomeCalculator();
    private SourceOfIncomeCalculator sourceOfIncomeCalculator = new SourceOfIncomeCalculator();
    private GuarantorsCalculator guarantorsCalculator = new GuarantorsCalculator();
    private CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(new PersonValidator(new PersonalDataValidator()),new PurposeOfLoanValidator(), new GuarantorValidator());
    private SelfEmployedScoringCalculator selfEmployedScoringCalculator =
            new SelfEmployedScoringCalculator();
    private PersonScoringCalculatorFactory calculator =
            new PersonScoringCalculatorFactory(selfEmployedScoringCalculator,educationCalculator,martialCalculator,incomeCalculator,sourceOfIncomeCalculator,guarantorsCalculator);

    private CreditApplicationService cut = new CreditApplicationService(calculator, creditApplicationValidator);

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(1, 500_000.00,
                PurposeOfLoanType.MORTGAGE, (byte) 30, 2, Education.MIDDLE, MartialStatus.MARRIED, 7_000.00);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
        assertEquals(200, decision.getScoring());
        //assertEquals(360000.00, decision.getCreditRate(), 0.01);
    }
    @Test
    public void test_scoring_calculator_test_when_years_since_founded_less_2_NEGATIVE_SCORING() {
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(3, 500_000.00,
                PurposeOfLoanType.MORTGAGE, (byte) 30, 2, Education.MIDDLE, MartialStatus.MARRIED, 7_000.00);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
        assertEquals(400, decision.getScoring());
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
        assertEquals(300, decision.getScoring());
    }

    @Test
    public void test_scoring_calculator_test_when_years_since_founded_more_2_NEGATIVE_SCORING_nevermind() {
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(2);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        assertEquals(DecisionType.POSITIVE, decision.getDecisionType());
        assertEquals(100, sourceOfIncomeCalculator.calculate(creditApplication.getPerson()));
    }
}