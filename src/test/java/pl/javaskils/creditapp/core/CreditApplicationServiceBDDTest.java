package pl.javaskils.creditapp.core;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.javaskils.creditapp.core.model.*;
import pl.javaskils.creditapp.core.scoring.EducationCalculator;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;
import pl.javaskils.creditapp.core.scoring.MartialCalculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;


public class CreditApplicationServiceBDDTest {

    private PersonScoringCalculator calculator = new PersonScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator());

    private CreditApplicationService cut = new CreditApplicationService(calculator);

    @Test
    public void test_scoring_calculator_test_NEGATIVE_SCORING(){
        //given
        //  LoanApplication loanApplication = LoanApplicationTestFactory.create(100000.00, PurposeOfLoanType.MORTGAGE, (byte) 25);
        LoanApplication loanApplication = LoanApplicationTestFactory.create();

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);

        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000.00, decision.getCreditRate(), 0.01);
    }
}