package service;

import model.Contact;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private Map<String, Contact> contactMap;
	
	public ContactService() {
		contactMap = new HashMap<>();
	}
	
	// Add a contact to the service
	public void addContact(Contact contact) {
		if (contactMap.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists.");
		}
		contactMap.put(contact.getContactId(), contact);
	}
	
    // Delete a contact by contact ID
    public void deleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contactMap.remove(contactId);
    }

    // Update first name by contact ID
    public void updateContactFirstName(String contactId, String firstName) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        Contact contact = contactMap.get(contactId);
        contact.setFirstName(firstName);
    }

    // Update last name by contact ID
    public void updateContactLastName(String contactId, String lastName) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        Contact contact = contactMap.get(contactId);
        contact.setLastName(lastName);
    }

    // Update phone number by contact ID
    public void updateContactPhone(String contactId, String phoneNumber) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        Contact contact = contactMap.get(contactId);
        contact.setPhone(phoneNumber);
    }

    // Update address by contact ID
    public void updateContactAddress(String contactId, String address) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        Contact contact = contactMap.get(contactId);
        contact.setAddress(address);
    }

    // Retrieve all contacts (for testing purposes)
    public Map<String, Contact> getAllContacts() {
        return contactMap;
    }
}	
	
