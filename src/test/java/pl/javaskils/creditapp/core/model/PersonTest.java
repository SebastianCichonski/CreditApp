package pl.javaskils.creditapp.core.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void Test_familyMembersShouldBeSortedByAgeDesc(){
        //given
        FamilyMember john = new FamilyMember("John", 18);
        FamilyMember jane = new FamilyMember("Jane", 40);
        FamilyMember susie = new FamilyMember("Susie", 5);
        List<FamilyMember> familyMembers = Arrays.asList(john,
                jane,
                susie);

        //when
        Person person = NaturalPerson.Builder.create()
                .withFamiliMember(familyMembers)
                .build();
        //then
        assertNotNull(person.getFamilyMembers());
        assertTrue(person.getFamilyMembers().size() == 3);
        assertEquals(jane, person.getFamilyMembers().get(0));
        assertEquals(john, person.getFamilyMembers().get(1));
        assertEquals(susie, person.getFamilyMembers().get(2));
    }

}