import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Message class.
 */
public class MessageTest {

    /**
     * Tests the constructor of the Message class.
     */
    @Test
    public void testConstructor() {
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        assertTrue(message.getReactions().isEmpty());
        assertFalse(message.isStatus());
        assertNull(message.getContent());
    }

    /**
     * Tests the setContent method of the Message class.
     */
    @Test
    public void testSetContent() {
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        String content = "Test content";
        message.setContent(content);
        assertEquals(content, message.getContent());
    }

    /**
     * Tests the setReaction method of the Message class.
     */
    @Test
    public void testSetReaction() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        Integer reactionID = 1;
        message.setReaction(author, reactionID);
        assertEquals(reactionID, message.getReactions().get(author));
    }

    /**
     * Tests the setAuthor method of the Message class.
     */
    @Test
    public void testSetAuthor() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        message.setAuthor(author);
        assertEquals(author, message.getAuthor());
    }

    /**
     * Tests the setStatus method of the Message class.
     */
    @Test
    public void testSetStatus() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        message.setStatus(true);
        assertTrue(message.isStatus());
        message.setStatus(false);
        assertFalse(message.isStatus());
    }

    /**
     * Tests the countReaction method of the Message class.
     */
    @Test
    public void testCountReaction() {
        Contact author1 = new Contact("Author1", 1); // use the existing constructor
        Contact author2 = new Contact("Author2", 2); // use the existing constructor
        Message message = new Message(author1); // use the existing constructor
        Integer reactionID = 1;
        message.setReaction(author1, reactionID);
        message.setReaction(author2, reactionID);
        assertEquals(2, message.countReaction(reactionID));
    }
}