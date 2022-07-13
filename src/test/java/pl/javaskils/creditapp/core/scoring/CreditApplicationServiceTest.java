package pl.javaskils.creditapp.core.scoring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CreditApplicationServiceTest {

    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private PersonScoringCalculator personScoringCalculatorMock;

    @Mock
    private PersonScoringCalculatorFactory personScoringCalculatorFactoryMock;

    @BeforeEach
    public void init() {
        BDDMockito.given(personScoringCalculatorFactoryMock.getCalculator(any(Person.class))).willReturn(personScoringCalculatorMock);
    }

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        CreditApplication creditApplication = CreditApplicationTestFactory.create(100000.00, PurposeOfLoanType.MORTGAGE, (byte) 25);
        BDDMockito.given(personScoringCalculatorMock.calculateScoring(eq(creditApplication.getPerson()))).willReturn(100);

        //when
        CreditApplicationDecision decision = cut.getDecision(creditApplication);

        //then
        Assert.assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
    }
}