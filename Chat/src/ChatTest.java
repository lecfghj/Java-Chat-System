import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Tester class for the Chat class
 */
public class ChatTest {
    // Define fields
    private Chat chat;
    private Message message1;
    private Message message2;

    /**
     * Setup method to initialize test data before each test
     */
    @BeforeEach
    public void setUp() {
        // Define members for a chat
        List<Contact> members = new LinkedList<>();
        Contact test1 = new Contact("A", 27376);
        Contact test2 = new Contact("B", 276311);
        members.add(test1);
        members.add(test2);
        // Define chat and add members in it
        chat = new Chat("chat", members);
        // Define test message
        message1 = new Message(test1);
        message1.setContent("Hello");
        message2 = new Message(test2);
        message2.setContent("Goodbye");
        // Add test messages to a chat
        chat.getMessages().add(message1);
        chat.getMessages().add(message2);
    }

    /**
     * Test case for setMembers method
     */
    @Test
    public void testSetMembers() {
        // Create test members
        List<Contact> newMembers = new LinkedList<>();
        Contact test3 = new Contact("C", 27377);
        Contact test4 = new Contact("D", 276312);
        newMembers.add(test3);
        newMembers.add(test4);
        // Set members
        chat.setMembers(newMembers);
        // Check if members were set properly
        assertEquals(2, chat.getMembers().size());
        assertEquals(test3, chat.getMembers().get(0));
        assertEquals(test4, chat.getMembers().get(1));
    }

    /**
     * Test case for setMessages method
     */
    @Test
    public void testSetMessages() {
        // Define a message and add it to the chat
        List<Message> newMessages = new LinkedList<>();
        Contact testContact = new Contact("E", 27378); // create a new contact
        Message message3 = new Message(testContact); // use the existing constructor
        message3.setContent("New message");
        newMessages.add(message3);
        chat.setMessages(newMessages);
        //  Check if the message was added properly
        assertEquals(1, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(0));
    }

    /**
     * Test case for addMember method
     */
    @Test
    public void testAddMember() {
        // Define a test member and add it to a chat
        Contact test3 = new Contact("C", 27377);
        chat.addMember(test3);
        // Check if member was added properly
        assertEquals(3, chat.getMembers().size());
        assertEquals(test3, chat.getMembers().get(2));
    }

    /**
     * Test case for removeMember method
     */
    @Test
    public void testRemoveMember() {
        // Remove first member of a test chat
        Contact test1 = chat.getMembers().get(0);
        chat.removeMember(test1);
        // Check if member was removed properly
        assertEquals(1, chat.getMembers().size());
        assertFalse(chat.getMembers().contains(test1));
    }

    /**
     * Test case for addMessage method
     */
    @Test
    public void testAddMessage() {
        // Create a test message and add it to a chat
        Contact testContact = new Contact("E", 27378); // create a new contact
        Message message3 = new Message(testContact); // use the existing constructor
        message3.setContent("New message");
        chat.addMessage(message3);
        // Check if message was added properly
        assertEquals(3, chat.getMessages().size());
        assertEquals(message3, chat.getMessages().get(2));
    }

    /**
     * Test case for readMessages method
     */
    @Test
    public void testReadMessages() {
        // Set all messages to unread
        for (Message message : chat.getMessages()) {
            message.setStatus(false);
        }
        // Read messages
        chat.readMessages();
        // Check if messages have been read properly
        for (Message message : chat.getMessages()) {
            assertTrue(message.isStatus());
        }
    }
}