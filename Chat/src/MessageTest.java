import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private Message message;
    private Contact author;

    @BeforeEach
    public void setup() {
        message = new Message();
        author = new Contact();
        author.setName("Test Author");
    }

    @Test
    public void testContent() {
        message.setContent("Test Content");
        assertEquals("Test Content", message.getContent());
    }

    @Test
    public void testReaction() {
        message.setReaction(1);
        assertEquals(1, message.getReaction());
    }

    @Test
    public void testAuthor() {
        message.setAuthor(author);
        assertEquals(author, message.getAuthor());
    }

    @Test
    public void testStatus() {
        message.setStatus(true);
        assertTrue(message.isStatus());
    }
}