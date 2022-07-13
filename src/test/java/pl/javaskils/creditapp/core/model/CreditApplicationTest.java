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
        CreditApplication ca = new CreditApplication(selfEmployed, null);
        assertTrue(ca.getPerson() instanceof SelfEmployed);
    }

    @Test
    public void getPerson_NaturalPerson_true() {
        CreditApplication ca = new CreditApplication(naturalPerson, null);
        assertTrue(ca.getPerson() instanceof NaturalPerson);
    }

    @Test
    public void getPerson_false() {
        CreditApplication ca = new CreditApplication(selfEmployed, null);
        assertFalse(ca.getPerson() instanceof NaturalPerson);
    }
}