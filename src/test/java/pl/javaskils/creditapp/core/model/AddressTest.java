package pl.javaskils.creditapp.core.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    void testEquals_true01() {
        Address address1 = new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie");
        Address address2 = new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie");
        assertTrue(address1.equals(address2));
    }

    @Test
    void testEquals_true02() {
        Address address1 = new Address("Ziejkowa", "Gostynin", "29d", "09-500","M");
        Address address2 = new Address("Ziejkowa", "Gostynin", "29d", "09-500","M");
        assertTrue(address1.equals(address2));
    }

    @Test
    void testEquals_true03() {
        Address address1 = new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie");
        Address address2 = new Address("ZIEJKOWA", "GOSTYNIN", "29d", "09-500", "Mazowieckie");
        assertTrue(address1.equals(address2));
    }

    @Test
    void testEquals_false01() {
        Address address1 = new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie");
        Address address2 = new Address("Ziejkowa", "Gostynin", "29", "09-500", "Mazowieckie");
        assertFalse(address1.equals(address2));
    }

    @Test
    void testEquals_false02() {
        Address address1 = new Address("Ziejkowa", "Gostynin", "29d", "09-500", "Mazowieckie");
        Address address2 = new Address("Ziejkowa", "Gostynin", "29d", "09-5OO", "Mazowieckie");
        assertFalse(address1.equals(address2));
    }
}