import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ImageProcessingTest {

    private ImageProcessing imageProcessing;

    @BeforeEach
    public void setUp() {
        imageProcessing = new ImageProcessing();
    }

    @Test
    public void testLoadImage_fileExists() throws IOException {
        BufferedImage result = imageProcessing.loadImage("Chat/src/defaultImage.png");
        assertNotNull(result);
    } //Used default image instead of a real image

    @Test
    public void testLoadImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadImage("path/to/nonexistentImage.jpg");
        assertNull(result);
    }

    @Test
    public void testLoadDefaultImage_fileExists() throws IOException {
        BufferedImage result = imageProcessing.loadDefaultImage("Chat/src/defaultImage.png");
        assertNotNull(result);
    } //Used default image instead of a real image

    @Test
    public void testLoadDefaultImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadDefaultImage("path/to/nonexistentDefault.jpg");
        assertNull(result);
    }
}