package pl.javaskils.creditapp.core;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskils.creditapp.core.model.*;
import pl.javaskils.creditapp.core.scoring.EducationCalculator;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;
import pl.javaskils.creditapp.core.scoring.MartialCalculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PersonScoringCalculatorTest {

    @InjectMocks
    private PersonScoringCalculator cut ;

    @Mock
    private IncomeCalculator incomeCalculatorMock ;
    @Mock
    private MartialCalculator martialCalculatorMock ;
    @Mock
    private EducationCalculator educationCalculatorMock ;

    @Test
    @DisplayName("test1")
    public void test_calculateScoring(){
        //given
        Person person = PersonTestFactory.create(2, Education.PRIMARY, MartialStatus.MARRIED);
        BDDMockito.given(incomeCalculatorMock.calculate(eq(person))).willReturn(50);
        BDDMockito.given(martialCalculatorMock.calculate(eq(person.getPersonalData()))).willReturn(200);
        BDDMockito.given(educationCalculatorMock.calculate(eq(person.getPersonalData()))).willReturn(100);

        //when
        int scoring = cut.calculateScoring(person);

        //then
        assertEquals(350, scoring);
    }













    //private PersonScoringCalculator cut = new PersonScoringCalculator();

//    @Test
//    public void test1() {
//        //given
//        Person person = PersonTestFactory.create(5000, 2, Education.PRIMARY, MartialStatus.MARRIED);
//        //when
//        int scoring = cut.calculateScoring(person);
//        //then
//        assertEquals(200, scoring);
//    }
//
//        @Test
//        public void test2() {
//            //given
//            Person person = PersonTestFactory.create(5500, 1, Education.MIDDLE, MartialStatus.DIVORCED);
//            //when
//            int scoring = cut.calculateScoring(person);
//            //then
//            assertEquals(500, scoring);
//        }
//
//            @Test
//            public void test3() {
//                //given
//                Person person = PersonTestFactory.create(9000, 3, Education.NONE, MartialStatus.SINGLE);
//                //when
//                int scoring = cut.calculateScoring(person);
//                //then
//                assertEquals(100, scoring);
//            }

}