import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ChatTest {

    private Chat chat;
    private Message message1;
    private Message message2;

    @BeforeEach
    public void testChatConstructor() {
        chat = new Chat();
        message1 = new Message();
        message1.setContent("Hello");
        message2 = new Message();
        message2.setContent("Goodbye");
        chat.getMessages().add(message1);
        chat.getMessages().add(message2);
    }

    @Test
    public void testGetMessages() {
        List<Message> messages = chat.getMessages();
        assertEquals(2, messages.size());
        assertEquals("Hello", messages.get(0).getContent());
        assertEquals("Goodbye", messages.get(1).getContent());
    }

    @Test
    public void testFindMessages() {
        List<Message> foundMessages = chat.findMessages("Hello");
        assertEquals(1, foundMessages.size());
        assertEquals("Hello", foundMessages.get(0).getContent());
    }

    @Test
    public void testReadMessages() {
        chat.readMessages();
        assertTrue(message1.isStatus());
        assertTrue(message2.isStatus());
    }

    @Test
    public void testFindMessagesNoMatch() {
        List<Message> foundMessages = chat.findMessages("Nonexistent");
        assertTrue(foundMessages.isEmpty());
    }

    @Test
    public void testReadMessagesAlreadyRead() {
        message1.setStatus(true);
        message2.setStatus(true);
        chat.readMessages();
        assertTrue(message1.isStatus());
        assertTrue(message2.isStatus());
    }
}