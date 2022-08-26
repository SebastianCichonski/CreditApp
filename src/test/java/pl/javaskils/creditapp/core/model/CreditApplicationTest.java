package pl.javaskils.creditapp.core.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public
class CreditApplicationTest {

    //@InjectMocks
   // private CreditApplication creditApplication;

    @Mock
    private SelfEmployed selfEmployed;

    @Mock
    private NaturalPerson naturalPerson;

    @Test
    public void getPerson_SelfEmployed_true() {
        CreditApplication ca = CreditApplication.Buider
                        .create()
                        .withPerson(selfEmployed)
                        .withPurposeOfLoan(null)
                        .withGuarantors(null)
                        .build();
        assertTrue(ca.getPerson() instanceof SelfEmployed);
    }

    @Test
    public void getPerson_NaturalPerson_true() {
        CreditApplication ca = CreditApplication.Buider
                .create()
                .withPerson(naturalPerson)
                .withPurposeOfLoan(null)
                .withGuarantors(null)
                .build();
        assertTrue(ca.getPerson() instanceof NaturalPerson);
    }

    @Test
    public void getPerson_false() {
        CreditApplication ca = CreditApplication.Buider
                        .create()
                        .withPerson(selfEmployed)
                        .withPurposeOfLoan(null)
                        .withGuarantors(null)
                        .build();
        assertFalse(ca.getPerson() instanceof NaturalPerson);
    }
}