import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;

public class ImageProcessingTest {

    private ImageProcessing imageProcessing;

    @BeforeEach
    public void setup() {
        imageProcessing = new ImageProcessing();
    }

    @Test
    public void testLoadImageValidPath() {
        BufferedImage image = imageProcessing.loadImage("src/testImage.png");
        assertNotNull(image, "Image should not be null for a valid path");
    }

    @Test
    public void testLoadImageInvalidPath() {
        BufferedImage image = imageProcessing.loadImage("src/nonexistentImage.png");
        assertNull(image, "Image should be null for an invalid path");
    }

    @Test
    public void testLoadImageExceptionHandling() {
        BufferedImage image = imageProcessing.loadImage(null);
        assertNull(image, "Image should be null when an exception is thrown");
    }
}