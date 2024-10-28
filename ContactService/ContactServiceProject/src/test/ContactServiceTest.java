package test;

import model.Contact;
import service.ContactService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
        service.addContact(contact);
        assertEquals(1, service.getAllContacts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
        service.addContact(contact1);
        Contact contact2 = new Contact("1234567890", "Jane", "Doe", "0987654321", "456 Oak St.");
        service.addContact(contact2);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertEquals(0, service.getAllContacts().size());
    }
    
    // Test for updating just the first name
    @Test
    public void testUpdateContactFirstName() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
    	service.addContact(contact);;
    	service.updateContactFirstName("1234567890", "Jane");
    	assertEquals("Jane",contact.getFirstName());
    	assertEquals("Doe", contact.getLastName()); // Check that last name is unchanged
    }
    
    // Test for updating just the last name
    @Test
    public void testUpdateContactLastName() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
    	service.addContact(contact);
    	service.updateContactLastName("1234567890", "Smith");
    	assertEquals("Smith", contact.getLastName());
    	assertEquals("John", contact.getFirstName()); // Check that first name is unchanged
    }
    
    // Test for updating just the phone number
    @Test
    public void testUpdateContactPhone() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
    	service.addContact(contact);;
    	service.updateContactPhone("1234567890",  "0987654321");;
    	assertEquals("0987654321", contact.getPhone());
    	assertEquals("John", contact.getFirstName()); // Check that first name is unchanged
    }
    
    // Test for updating just the address
    @Test
    public void testUpdateContactAddress() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St.");
    	service.addContact(contact);;
    	service.updateContactAddress("1234567890",  "456 Oak St.");
    	assertEquals("456 Oak St.", contact.getAddress());
    	assertEquals("John", contact.getFirstName()); // Check that first name is unchanged
    }
    
}
