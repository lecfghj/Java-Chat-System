import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setup() {
        contact = new Contact();
    }

    @Test
    public void testConstructor() {
        assertNotNull(contact.getDateAdded());
        assertNotNull(contact.getProfileImage());
    }

    @Test
    public void testSetName() {
        contact.setName("Test Name");
        assertEquals("Test Name", contact.getName());
    }

    @Test
    public void testSetPhoneNumber() {
        contact.setPhoneNumber(1234567890);
        assertEquals(1234567890, contact.getPhoneNumber());
    }

    @Test
    public void testSetProfileImage() {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        contact.setProfileImage(image);
        assertEquals(image, contact.getProfileImage());
    }
}