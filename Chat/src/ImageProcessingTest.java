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
    public void testLoadImage_fileExists() {
        BufferedImage result = imageProcessing.loadImage("src/test/resources/testImage.jpg");
        assertNotNull(result);
    } //Test does not pass, as the image does not exist

    @Test
    public void testLoadImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadImage("path/to/nonexistent/image.jpg");
        assertNull(result);
    }

    @Test
    public void testLoadDefaultImage_fileExists() {
        BufferedImage result = imageProcessing.loadDefaultImage("src/test/resources/defaultImage.jpg");
        assertNotNull(result);
    } //Test does not pass, as the image does not exist

    @Test
    public void testLoadDefaultImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadDefaultImage("path/to/nonexistent/default.jpg");
        assertNull(result);
    }
}