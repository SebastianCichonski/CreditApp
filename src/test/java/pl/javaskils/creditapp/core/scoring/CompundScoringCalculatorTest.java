package pl.javaskils.creditapp.core.scoring;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CompundScoringCalculatorTest {
    private PersonCalculator personCalculator1Mock = Mockito.mock(PersonCalculator.class);
    private PersonCalculator personCalculator2Mock = Mockito.mock(PersonCalculator.class);
    private PersonCalculator personCalculator3Mock = Mockito.mock(PersonCalculator.class);
    private PersonCalculator personCalculator4Mock = Mockito.mock(PersonCalculator.class);

    private CompundScoringCalculator cut1 =
            new CompundScoringCalculator(personCalculator1Mock,personCalculator2Mock,personCalculator3Mock,personCalculator4Mock);

    @Test
    @DisplayName("test1")
    public void test_calculateScoring(){
        //given
        Person person = PersonTestFactory.create(2, Education.PRIMARY, MartialStatus.MARRIED);
        BDDMockito.given(personCalculator1Mock.calculate(eq(person))).willReturn(50);
        BDDMockito.given(personCalculator2Mock.calculate(eq(person))).willReturn(200);
        BDDMockito.given(personCalculator3Mock.calculate(eq(person))).willReturn(100);
        BDDMockito.given(personCalculator4Mock.calculate(eq(person))).willReturn(0);

        //when
        int scoring1 = cut1.calculate(person);
        //then
        assertEquals(350, scoring1);


        //when
        int scoring2 = cut1.calculate(person);
        //then
        assertEquals(350, scoring2);
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