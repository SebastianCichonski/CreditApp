package pl.javaskils.creditapp.core.scoring;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.Guarantor;

import java.util.TreeSet;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class GuarantorsCalculatorTest {

    @InjectMocks
   private GuarantorsCalculator calculator = new GuarantorsCalculator();

    @Test
    public void calculate_01(){
        TreeSet<Guarantor> guarantors = new TreeSet<>();
        guarantors.add(new Guarantor("80011915096", 42));
        guarantors.add(new Guarantor("82050714908", 38));
        guarantors.add(new Guarantor("81011915096", 40));
        guarantors.add(new Guarantor("21210802635", 20));
        CreditApplication creditApplication = CreditApplication.Buider
                .create()
                .withPerson(null)
                .withPurposeOfLoan(null)
                .withGuarantors(guarantors)
                .build();
        int guarantorsPoints = calculator.calculate(creditApplication);
        assertEquals(150,guarantorsPoints );
    }


}