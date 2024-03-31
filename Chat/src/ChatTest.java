import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains unit tests for the Chat class.
 */
public class ChatTest {

    private Chat chat;
    private Message message1;
    private Message message2;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setUp() {
        List<Contact> members = new LinkedList<>();
        Contact test1 = new Contact("A", 27376);
        Contact test2 = new Contact("B", 276311);
        members.add(test1);
        members.add(test2);
        chat = new Chat("chat", members);
        message1 = new Message(test1);
        message1.setContent("Hello");
        message2 = new Message(test2);
        message2.setContent("Goodbye");
        chat.getMessages().add(message1);
        chat.getMessages().add(message2);
    }

    /**
     * Tests the setMembers() method of the Chat class.
     */
    @Test
    public void testSetMembers() {
        List<Contact> newMembers = new LinkedList<>();
        Contact test3 = new Contact("C", 27377);
        Contact test4 = new Contact("D", 276312);
        newMembers.add(test3);
        newMembers.add(test4);
        chat.setMembers(newMembers);
        assertEquals(2, chat.getMembers().size());
        assertEquals(test3, chat.getMembers().get(0));
        assertEquals(test4, chat.getMembers().get(1));
    }

    /**
     * Tests the setMessages() method of the Chat class.
     */
    @Test
    public void testSetMessages() {
        List<Message> newMessages = new LinkedList<>();
        Contact testContact = new Contact("E", 27378); // create a new contact
        Message message3 = new Message(testContact); // use the existing constructor
        message3.setContent("New message");
        newMessages.add(message3);
        chat.setMessages(newMessages);
        assertEquals(1, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(0));
    }

    /**
     * Tests the addMember() method of the Chat class.
     */
    @Test
    public void testAddMember() {
        Contact test3 = new Contact("C", 27377);
        chat.addMember(test3);
        assertEquals(3, chat.getMembers().size());
        assertEquals(test3, chat.getMembers().get(2));
    }

    /**
     * Tests the removeMember() method of the Chat class.
     */
    @Test
    public void testRemoveMember() {
        Contact test1 = chat.getMembers().get(0);
        chat.removeMember(test1);
        assertEquals(1, chat.getMembers().size());
        assertFalse(chat.getMembers().contains(test1));
    }

    /**
     * Tests the addMessage() method of the Chat class.
     */
    @Test
    public void testAddMessage() {
        Contact testContact = new Contact("E", 27378); // create a new contact
        Message message3 = new Message(testContact); // use the existing constructor
        message3.setContent("New message");
        chat.addMessage(message3);
        assertEquals(3, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(2));
    }

    /**
     * Tests the readMessages() method of the Chat class.
     */
    @Test
    public void testReadMessages() {
        for (Message message : chat.getMessages()) {
            message.setStatus(false);
        }
        chat.readMessages();
        for (Message message : chat.getMessages()) {
            assertTrue(message.isStatus());
        }
    }
}