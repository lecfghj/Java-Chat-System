import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester class for Message class
 */
public class MessageTest {
    /**
     * Test case for default constructor
     */
    @Test
    public void testConstructor() {
        // Create a test contact and a message
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        // Check if initial state of an object is as expected
        assertTrue(message.getReactions().isEmpty());
        assertFalse(message.isStatus());
        assertNull(message.getContent());
    }

    /**
     * Test case for setContent class
     */
    @Test
    public void testSetContent() {
        // Create a test message
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        // Set its content
        String content = "Test content";
        message.setContent(content);
        // Check if content was set properly
        assertEquals(content, message.getContent());
    }

    /**
     * Test case for setReaction method
     */
    @Test
    public void testSetReaction() {
        // Create a test message
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        // Set reaction
        Integer reactionID = 1;
        message.setReaction(author, reactionID);
        // Check if reaction was set properly
        assertEquals(reactionID, message.getReactions().get(author));
    }

    /**
     * TEst case for setAuthor method
     */
    @Test
    public void testSetAuthor() {
        // Create a test message
        Contact author = new Contact("1",1);
        Contact notAuthor = new Contact("2", 2);
        Message message = new Message(notAuthor);
        // Set author
        message.setAuthor(author);
        assertEquals(author, message.getAuthor());
    }

    /**
     * Test case for setReaction method
     */
    @Test
    public void testSetStatus() {
        // Create a test message
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        // Set status and check if it was set properly
        message.setStatus(true);
        assertTrue(message.isStatus());
        message.setStatus(false);
        assertFalse(message.isStatus());
    }

    /**
     * Test case for countReaction method
     */
    @Test
    public void testCountReaction() {
        // Create test contacts and
        Contact author1 = new Contact("Author1", 1); // use the existing constructor
        Contact author2 = new Contact("Author2", 2); // use the existing constructor
        // Create test message
        Message message = new Message(author1); // use the existing constructor
        Integer reactionID = 1;
        // Set reaction
        message.setReaction(author1, reactionID);
        message.setReaction(author2, reactionID);
        // Check if reaction was set
        assertEquals(2, message.countReaction(reactionID));
    }
}