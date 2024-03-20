import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

public class ContactTest {

    @Test
    public void testSetName() {
        Contact contact = new Contact();
        contact.setName("Test Name");
        assertEquals("Test Name", contact.getName());
    }

    @Test
    public void testSetPhoneNumber() {
        Contact contact = new Contact();
        contact.setPhoneNumber(1234567890);
        assertEquals(1234567890, contact.getPhoneNumber());
    }

    @Test
    public void testSetProfileImage() {
        Contact contact = new Contact();
        ImageIcon imageIcon = new ImageIcon("Chat/src/defaultImage.png");
        contact.setProfileImage(imageIcon);
        assertEquals(imageIcon, contact.getProfileImage());
    }

    @Test
    public void testDateAdded() {
        Contact contact = new Contact();
        LocalDateTime now = LocalDateTime.now();
        assertTrue(contact.getDateAdded().isBefore(now.plusSeconds(1)) && contact.getDateAdded().isAfter(now.minusSeconds(1)));
    }

    @Test
    public void testSendMessage() {
        Contact contact = new Contact();
        contact.sendMessage("Hello");
        assertEquals(1, contact.getLastThreeMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
    }
}