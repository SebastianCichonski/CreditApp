package pl.javaskils.creditapp.core.scoring;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskils.creditapp.core.CreditApplicationDecision;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.DecisionType;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.*;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
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