import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Tester class for User class
 */
public class UserTest {
    /**
     * Test case for addContact method
     */
    @Test
    public void testAddContact() {
        // Create a test contact and add it to contacts
        User user = new User("A", 234);
        Contact contact = new Contact("1",1);
        contact.setName("Test Contact");
        user.addContact(contact);
        // Check if test contact was added properly
        assertEquals(1, user.getContactList().size());
        assertEquals("Test Contact", user.getContactList().get(0).getName());
    }

    /**
     * Test case for setContactList method
     */
    @Test
    public void testSetContactList() {
        // Create test user
        User user = new User("A", 234);
        // Create contacts list with test contacts
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact("1",1); // use the existing constructor
        contact1.setName("B");
        Contact contact2 = new Contact("2",2); // use the existing constructor
        contact2.setName("A");
        // Add contacts to a list
        contacts.add(contact1);
        contacts.add(contact2);
        // Set contacts list
        user.setContactList(contacts);
        // Check if contacts list was set properly
        assertEquals(2, user.getContactList().size());
        assertEquals("B", user.getContactList().get(0).getName());
        assertEquals("A", user.getContactList().get(1).getName());
    }

    /**
     * Test case for sortContactsAlphabetically method
     */
    @Test
    public void testSortContactsAlphabetically() {
        // Create contacts list
        User user = new User("0", 123);
        Contact contact1 = new Contact("1",1);
        contact1.setName("B");
        Contact contact2 = new Contact("2",2);
        contact2.setName("A");
        user.addContact(contact1);
        user.addContact(contact2);
        // Sort contacts list
        List<Contact> sortedContacts = user.sortContactsAlphabetically();
        // Check fi list was sorted
        assertEquals("A", sortedContacts.get(0).getName());
        assertEquals("B", sortedContacts.get(1).getName());
    }

    /**
     * Test case for sortContactsAlphabeticallyEfficient method
     */
    @Test
    public void testSortContactsAlphabeticallyEfficient() {
        // Create a test contacts list
        User user = new User("0", 123);
        Contact contact1 = new Contact("1",1); // use the existing constructor
        contact1.setName("B");
        Contact contact2 = new Contact("2",2); // use the existing constructor
        contact2.setName("A");
        user.addContact(contact1);
        user.addContact(contact2);
        // Sort it
        List<Contact> sortedContacts = user.sortContactsAlphabeticallyEfficient();
        // Check if list was sorted
        assertEquals("A", sortedContacts.get(0).getName());
        assertEquals("B", sortedContacts.get(1).getName());
    }

    /**
     * Test case for sortContactsNewestToOldest method
     * @throws InterruptedException
     */
    @Test
    public void testSortContactsNewestToOldest() throws InterruptedException {
        // Create test contacts list
        User user = new User("0", 123);
        Contact contact1 = new Contact("1",1);
        contact1.setName("A");
        contact1.setPhoneNumber(12345678);
        user.addContact(contact1);

        // Introduce a delay
        Thread.sleep(1000);

        Contact contact2 = new Contact("2",2);
        contact2.setName("B");
        contact2.setPhoneNumber(34567890);
        user.addContact(contact2);
        // Sort contacts list
        List<Contact> sortedContacts = user.sortContactsNewestToOldest();
        // Check iw the list was sorted properly
        assertEquals(contact2, sortedContacts.get(0));
        assertEquals(contact1, sortedContacts.get(1));
    }

    /**
     * Test case for sortContactsOldestToNewest method
     * @throws InterruptedException
     */
    @Test
    public void testSortContactsOldestToNewest() throws InterruptedException {
        // Create test contacts list
        User user = new User("0",987);
        Contact contact1 = new Contact("1",1);
        contact1.setName("A");
        contact1.setPhoneNumber(12345678);
        user.addContact(contact1);

        // Introduce a delay
        Thread.sleep(1000);

        Contact contact2 = new Contact("2",2);
        contact2.setName("B");
        contact2.setPhoneNumber(34567890);
        user.addContact(contact2);
        // Sort test contacts list
        List<Contact> sortedContacts = user.sortContactsOldestToNewest();
        // Check if list was sorted properly
        assertEquals(contact1, sortedContacts.get(0));
        assertEquals(contact2, sortedContacts.get(1));
    }
}