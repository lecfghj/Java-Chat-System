import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testConstructor() {
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        assertTrue(message.getReactions().isEmpty());
        assertFalse(message.isStatus());
        assertNull(message.getContent());
    }

    @Test
    public void testSetContent() {
        Contact c1 = new Contact("1", 1);
        Message message = new Message(c1);
        String content = "Test content";
        message.setContent(content);
        assertEquals(content, message.getContent());
    }

    @Test
    public void testSetReaction() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        Integer reactionID = 1;
        message.setReaction(author, reactionID);
        assertEquals(reactionID, message.getReactions().get(author));
    }

    @Test
    public void testSetAuthor() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        message.setAuthor(author);
        assertEquals(author, message.getAuthor());
    }

    @Test
    public void testSetStatus() {
        Contact author = new Contact("1",1);
        Message message = new Message(author);
        message.setStatus(true);
        assertTrue(message.isStatus());
        message.setStatus(false);
        assertFalse(message.isStatus());
    }

    @Test
    public void testCountReaction() {
        Message message = new Message();
        Contact author1 = new Contact();
        Contact author2 = new Contact();
        Integer reactionID = 1;
        message.setReaction(author1, reactionID);
        message.setReaction(author2, reactionID);
        assertEquals(2, message.countReaction(reactionID));
    }
}