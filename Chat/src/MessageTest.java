import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
public void testConstructorWithAuthor() {
    Contact author = new Contact();
    Message message = new Message(author);
    assertEquals(author, message.getAuthor());
    assertTrue(message.getReactions().isEmpty());
    assertFalse(message.isStatus());
    assertNull(message.getContent());
}

@Test
public void testSetReactionWithNullParameters() {
    Message message = new Message();
    message.setReaction(null, null);
    assertTrue(message.getReactions().isEmpty());
}

    @Test
    public void testSetContent() {
        Message message = new Message();
        String content = "Test content";
        message.setContent(content);
        assertEquals(content, message.getContent());
    }

    @Test
    public void testSetReaction() {
        Message message = new Message();
        Contact author = new Contact();
        Integer reactionID = 1;
        message.setReaction(author, reactionID);
        assertEquals(reactionID, message.getReactions().get(author));
    }

    @Test
    public void testSetAuthor() {
        Message message = new Message();
        Contact author = new Contact();
        message.setAuthor(author);
        assertEquals(author, message.getAuthor());
    }

    @Test
    public void testSetStatus() {
        Message message = new Message();
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