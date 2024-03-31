import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class UserTest {

    @Test
    public void testAddContact() {
        User user = new User("A", 234);
        Contact contact = new Contact("1",1);
        contact.setName("Test Contact");
        user.addContact(contact);
        assertEquals(1, user.getContactList().size());
        assertEquals("Test Contact", user.getContactList().get(0).getName());
    }

    @Test
    public void testSetContactList() {
        User user = new User("A", 234);
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setName("B");
        Contact contact2 = new Contact();
        contact2.setName("A");
        contacts.add(contact1);
        contacts.add(contact2);
        user.setContactList(contacts);
        assertEquals(2, user.getContactList().size());
        assertEquals("B", user.getContactList().get(0).getName());
        assertEquals("A", user.getContactList().get(1).getName());
    }

    @Test
    public void testSortContactsAlphabetically() {
        User user = new User("0", 123);
        Contact contact1 = new Contact("1",1);
        contact1.setName("B");
        Contact contact2 = new Contact("2",2);
        contact2.setName("A");
        user.addContact(contact1);
        user.addContact(contact2);

        List<Contact> sortedContacts = user.sortContactsAlphabetically();
        assertEquals("A", sortedContacts.get(0).getName());
        assertEquals("B", sortedContacts.get(1).getName());
    }

    @Test
    public void testSortContactsAlphabeticallyEfficient() {
        User user = new User("0", 123);
        Contact contact1 = new Contact();
        contact1.setName("B");
        Contact contact2 = new Contact();
        contact2.setName("A");
        user.addContact(contact1);
        user.addContact(contact2);
        List<Contact> sortedContacts = user.sortContactsAlphabeticallyEfficient();
        assertEquals("A", sortedContacts.get(0).getName());
        assertEquals("B", sortedContacts.get(1).getName());
    }

    @Test
    public void testSortContactsNewestToOldest() throws InterruptedException {
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

        List<Contact> sortedContacts = user.sortContactsNewestToOldest();
        assertEquals(contact2, sortedContacts.get(0));
        assertEquals(contact1, sortedContacts.get(1));
    }

    @Test
    public void testSortContactsOldestToNewest() throws InterruptedException {
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

        List<Contact> sortedContacts = user.sortContactsOldestToNewest();
        assertEquals(contact1, sortedContacts.get(0));
        assertEquals(contact2, sortedContacts.get(1));
    }
}