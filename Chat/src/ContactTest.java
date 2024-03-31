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
    public void testCreateChat() {
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        assertEquals(1, contact.getChats().size());
        assertEquals("Test Chat", contact.getChats().get(0).getName());
    }

    @Test
    public void testSetMessages() {
        Chat chat = new Chat("Test Chat", new LinkedList<>());
        List<Message> newMessages = new LinkedList<>();
        Message message3 = new Message();
        message3.setContent("New message");
        newMessages.add(message3);
        chat.setMessages(newMessages);
        assertEquals(1, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(0));
    }

    @Test
    public void testGetLastThreeMessages() {
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        contact.sendMessage("Hello", chat);
        contact.sendMessage("How are you?", chat);
        contact.sendMessage("Goodbye", chat);
        assertEquals(3, contact.getLastThreeMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
        assertEquals("How are you?", contact.getLastThreeMessages().get(1).getContent());
        assertEquals("Goodbye", contact.getLastThreeMessages().get(2).getContent());
    }

    @Test
    public void testSendMessage() {
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        contact.sendMessage("Hello", chat);
        assertEquals(1, contact.getLastThreeMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
        assertEquals(1, chat.getMessages().size());
        assertEquals("Hello", chat.getMessages().get(0).getContent());
    }

    @Test
    public void testSendMessageMoreThanThree() {
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        contact.sendMessage("Hello", chat);
        contact.sendMessage("How are you?", chat);
        contact.sendMessage("I'm fine", chat);
        contact.sendMessage("Goodbye", chat);
        assertEquals(3, contact.getLastThreeMessages().size());
        assertEquals("How are you?", contact.getLastThreeMessages().get(0).getContent());
        assertEquals("I'm fine", contact.getLastThreeMessages().get(1).getContent());
        assertEquals("Goodbye", contact.getLastThreeMessages().get(2).getContent());
    }
}