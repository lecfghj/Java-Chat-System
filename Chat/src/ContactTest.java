import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ContactTest {

    @Test
    public void testSetName() {
        Contact contact = new Contact();
        contact.setName("Test Name");
        assertEquals("Test Name", contact.getName());
    }

    @Test
    public void testSetPhoneNumber() {
        Contact contact = new Contact();
        contact.setPhoneNumber(1234567890);
        assertEquals(1234567890, contact.getPhoneNumber());
    }

    /*
    @Test
    public void testSetProfileImage() {
        Contact contact = new Contact();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        contact.setProfileImage(image);
        assertEquals(image, contact.getProfileImage());
    }*/

    @Test
    public void testDateAdded() {
        Contact contact = new Contact();
        LocalDateTime now = LocalDateTime.now();
        assertTrue(contact.getDateAdded().isBefore(now.plusSeconds(1)) && contact.getDateAdded().isAfter(now.minusSeconds(1)));
    }
}