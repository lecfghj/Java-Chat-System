import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for image processing, is not being used by a chat program
 */
public class ImageProcessingTest {
    private ImageProcessing imageProcessing;
    private final String defaultImagePath = "Chat/src/defaultImage.png";

    @BeforeEach
    public void setUp() {
        imageProcessing = new ImageProcessing();
    }

    @Test
    public void testLoadImage() {
        String imagePath = "Chat/src/testImage.png";
        BufferedImage image = imageProcessing.loadImage(imagePath);
        assertNotNull(image, "Image should not be null if file exists");
    } // only image that exists in the file is the default image so this test fails

    @Test
    public void testLoadImageFileNotFound() {
        String imagePath = "Chat/src/nonExistentImage.png";
        BufferedImage image = imageProcessing.loadImage(imagePath);
        assertNull(image, "Image should be null if file does not exist");
    }

    @Test
    public void testLoadDefaultImage() {
        BufferedImage image = imageProcessing.loadDefaultImage(defaultImagePath);
        assertNotNull(image, "Default image should not be null if file exists");
    }

    @Test
    public void testLoadDefaultImageFileNotFound() {
        String imagePath = "Chat/src/nonExistentDefaultImage.png";
        BufferedImage image = imageProcessing.loadDefaultImage(imagePath);
        assertNull(image, "Default image should be null if file does not exist");
    }
}