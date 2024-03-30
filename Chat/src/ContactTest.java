import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import java.util.List;

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
        Contact contact = new Contact("Aaron", 374322);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("", members);
        Chat chat = contact.getChats().get(0);        contact.sendMessage("Hello", chat);

        assertEquals(1, contact.getLastThreeMessages().size());
        assertEquals(1, chat.getMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
        assertEquals("Hello", chat.getMessages().get(0).getContent());
    }
}