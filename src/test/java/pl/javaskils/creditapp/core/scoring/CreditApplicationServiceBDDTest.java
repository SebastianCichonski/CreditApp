package pl.javaskils.creditapp.core.scoring;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.javaskils.creditapp.core.CreditApplicationDecision;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.DecisionType;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;


public class CreditApplicationServiceBDDTest {

    private PersonScoringCalculator calculator = new PersonScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator());

    private CreditApplicationService cut = new CreditApplicationService(calculator);

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        //  LoanApplication creditApplication = LoanApplicationTestFactory.create(100000.00, PurposeOfLoanType.MORTGAGE, (byte) 25);
        CreditApplication creditApplication = CreditApplicationTestFactory.create();

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        Assert.assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000.00, decision.getCreditRate(), 0.01);
    }
}