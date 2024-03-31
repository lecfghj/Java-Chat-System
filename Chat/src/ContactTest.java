import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import java.util.List;

/**
 * Tester class for Contact Class
 */
public class ContactTest {
    /**
     * Test case for setName method
     */
    @Test
    public void testSetName() {
        // Create a contact and set a name
        Contact contact = new Contact("1",1);
        contact.setName("Test Name");
        // Check if name was set properly
        assertEquals("Test Name", contact.getName());
    }

    /**
     * Test case for setPhoneNumber method
     */
    @Test
    public void testSetPhoneNumber() {
        // Create a contact and set a phone number
        Contact contact = new Contact("1",1);
        contact.setPhoneNumber(1234567890);
        // Check if phone number was set properly
        assertEquals(1234567890, contact.getPhoneNumber());
    }

    /**
     * Test case for setProfileImage method
     */
    @Test
    public void testSetProfileImage() {
        // Create a contact and set profile image
        Contact contact = new Contact("1",1);
        ImageIcon imageIcon = new ImageIcon("Chat/src/defaultImage.png");
        contact.setProfileImage(imageIcon);
        // Check if image was set
        assertEquals(imageIcon, contact.getProfileImage());
    }

    /**
     * Test case for getDateAdded method
     */
    @Test
    public void testDateAdded() {
        // Create a new contact
        Contact contact = new Contact("1",1);
        // Save current time to a variable
        LocalDateTime now = LocalDateTime.now();
        // Check that timeAdded was assigned to contact properly
        assertTrue(contact.getDateAdded().isBefore(now.plusSeconds(1)) && contact.getDateAdded().isAfter(now.minusSeconds(1)));
    }

    /**
     * Test case for createChat method
     */
    @Test
    public void testCreateChat() {
        // Create new chat and add a member to it
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        contact.createChat("Test Chat", members);
        // Check if member was added properly
        assertEquals(1, contact.getChats().size());
        assertEquals("Test Chat", contact.getChats().get(0).getName());
    }

    /**
     * Test case for setMessage method
     */
    @Test
    public void testSetMessages() {
        // Create a chat with one member
        Chat chat = new Chat("Test Chat", new LinkedList<>());
        List<Message> newMessages = new LinkedList<>();
        Contact testContact = new Contact("E", 27378); // create a new contact
        Message message3 = new Message(testContact); // use the existing constructor
        // Create a message and set it to a chat
        message3.setContent("New message");
        newMessages.add(message3);
        chat.setMessages(newMessages);
        // Check if message was set successfully
        assertEquals(1, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(0));
    }

    /**
     * Test case for getLastThreeMessages method
     */
    @Test
    public void testGetLastThreeMessages() {
        // Create a chat
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        // Add messages to a chat
        contact.sendMessage("Hello", chat);
        contact.sendMessage("How are you?", chat);
        contact.sendMessage("Goodbye", chat);

        // Check if messages were added to last three messages list
        assertEquals(3, contact.getLastThreeMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
        assertEquals("How are you?", contact.getLastThreeMessages().get(1).getContent());
        assertEquals("Goodbye", contact.getLastThreeMessages().get(2).getContent());
    }

    /**
     * Test case for sendMessage method
     */
    @Test
    public void testSendMessage() {
        // Create a chat
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        // Send a message to a chat
        contact.sendMessage("Hello", chat);
        // Check if message was sent successfully
        assertEquals(1, contact.getLastThreeMessages().size());
        assertEquals("Hello", contact.getLastThreeMessages().get(0).getContent());
        assertEquals(1, chat.getMessages().size());
        assertEquals("Hello", chat.getMessages().get(0).getContent());
    }

    /**
     * Test case for sendMessage method
     */
    @Test
    public void testSendMessageMoreThanThree() {
        // Create a chat
        Contact contact = new Contact("Test Name", 1234567890);
        List<Contact> members = new LinkedList<>();
        members.add(contact);
        contact.createChat("Test Chat", members);
        Chat chat = contact.getChats().get(0);
        // Send more than 3 messages to it
        contact.sendMessage("Hello", chat);
        contact.sendMessage("How are you?", chat);
        contact.sendMessage("I'm fine", chat);
        contact.sendMessage("Goodbye", chat);
        // Check if last messages were assigned properly
        assertEquals(3, contact.getLastThreeMessages().size());
        assertEquals("How are you?", contact.getLastThreeMessages().get(0).getContent());
        assertEquals("I'm fine", contact.getLastThreeMessages().get(1).getContent());
        assertEquals("Goodbye", contact.getLastThreeMessages().get(2).getContent());
    }
}