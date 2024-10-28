package test;

import model.Contact;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St.", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIdTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameTooLong() {
        new Contact("1234567890", "Johnathan", "Doe", "1234567890", "123 Elm St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneTooShort() {
        new Contact("1234567890", "John", "Doe", "12345678", "123 Elm St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneNotDigits() {
        new Contact("1234567890", "John", "Doe", "123ABC7890", "123 Elm St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddressTooLong() {
        new Contact("1234567890", "John", "Doe", "1234567890", "This is an address that is far too long to be valid.");
    }
}
