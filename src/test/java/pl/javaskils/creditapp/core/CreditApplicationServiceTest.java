package pl.javaskils.creditapp.core;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.javaskils.creditapp.core.model.*;

import static org.mockito.ArgumentMatchers.eq;


public class CreditApplicationServiceTest {

    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private PersonScoringCalculator calculatorMock;

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(100000.00, PurposeOfLoanType.MORTGAGE, (byte) 25);
        BDDMockito.given(calculatorMock.calculateScoring(eq(loanApplication.getPerson()))).willReturn(100);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);

        //then
        Assert.assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
    }
}