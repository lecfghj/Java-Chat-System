import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.time.LocalDateTime;

public class UserTest {

    @Test
    public void testAddContact() {
        User user = new User();
        Contact contact = new Contact();
        contact.setName("Test Contact");
        user.addContact(contact);
        assertEquals(1, user.getContactList().size());
        assertEquals("Test Contact", user.getContactList().get(0).getName());
    }

    @Test
    public void testSortContactsAlphabetically() {
        User user = new User();
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
    public void testSortContactsNewestToOldest() {
        User user = new User();
        Contact contact1 = new Contact();
        contact1.setDateAdded(LocalDateTime.now().minusDays(1));
        user.addContact(contact1);

        Contact contact2 = new Contact();
        contact2.setDateAdded(LocalDateTime.now());
        user.addContact(contact2);

        List<Contact> sortedContacts = user.sortContactsNewestToOldest();
        assertEquals(contact2, sortedContacts.get(0));
        assertEquals(contact1, sortedContacts.get(1));
    } 

    @Test
    public void testSortContactsOldestToNewest() {
        User user = new User();
        Contact contact1 = new Contact();
        contact1.setDateAdded(LocalDateTime.now().minusDays(1));
        user.addContact(contact1);

        Contact contact2 = new Contact();
        contact2.setDateAdded(LocalDateTime.now());
        user.addContact(contact2);

        List<Contact> sortedContacts = user.sortContactsOldestToNewest();
        assertEquals(contact1, sortedContacts.get(0));
        assertEquals(contact2, sortedContacts.get(1));
    } 
}