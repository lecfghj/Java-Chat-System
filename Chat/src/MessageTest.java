import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {


    @Test
    public void testConstructor() {
        Message message = new Message();
        assertEquals(0, message.getReaction());
        assertFalse(message.isStatus());
        assertNull(message.getContent());
        assertNull(message.getAuthor());
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
        int reaction = 1;
        message.setReaction(reaction);
        assertEquals(reaction, message.getReaction());
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
}