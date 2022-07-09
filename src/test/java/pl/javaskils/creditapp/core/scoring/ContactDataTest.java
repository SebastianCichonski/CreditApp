package pl.javaskils.creditapp.core.scoring;

import org.junit.jupiter.api.Test;
import pl.javaskils.creditapp.core.model.Address;
import pl.javaskils.creditapp.core.model.ContactData;

import static org.junit.jupiter.api.Assertions.*;

public class ContactDataTest {

    @Test
    public void shouldSetOptionalCorrespondenceAddressWhenHomeAddressIsTheSame(){
        //Given & When
        ContactData cd = ContactData.Builder.create()
                .withHomeAddress(new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie"))
                .withCorrespondenceAddress(new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie"))
                .build();

        assertTrue(cd.getCorrespondenceAddress().isEmpty());
    }
    @Test
    public void shouldSetOptionalCorrespondenceAddressWhenHomeAddressIsNOTTheSame(){
        //Given & When
        ContactData cd = ContactData.Builder.create()
                .withHomeAddress(new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie"))
                .withCorrespondenceAddress(new Address("Bierzewicka", "Gostynin", "29", "09-500", "Mazowieckie"))
                .build();

        assertTrue(cd.getCorrespondenceAddress().isPresent());
    }

}