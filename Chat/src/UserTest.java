import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Contact contact;

    @BeforeEach
    public void setup() {
        user = new User();
        contact = new Contact();
        contact.setName("Test Contact");
    }

    @Test
    public void testAddContact() {
        user.addContact(contact);
        assertTrue(user.getContactList().contains(contact));
    }
}