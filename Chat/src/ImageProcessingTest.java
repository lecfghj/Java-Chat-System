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
<<<<<<< HEAD
    public void testLoadImage_fileExists() throws IOException {
        BufferedImage result = imageProcessing.loadImage("src/defaultImage.png");
        assertNotNull(result);
    } //Default image does not exist
=======
    public void testLoadImage_fileExists() {
        BufferedImage result = imageProcessing.loadImage("src/test/resources/testImage.jpg");
        assertNotNull(result);
    } //Test does not pass, as the image does not exist

>>>>>>> origin/master
    @Test
    public void testLoadImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadImage("path/to/nonexistentImage.jpg");
        assertNull(result);
    }

    @Test
<<<<<<< HEAD
    public void testLoadDefaultImage_fileExists() throws IOException {
        BufferedImage result = imageProcessing.loadDefaultImage("src/defaultImage.png");
        assertNotNull(result);
    } //Default image does not exist
=======
    public void testLoadDefaultImage_fileExists() {
        BufferedImage result = imageProcessing.loadDefaultImage("src/test/resources/defaultImage.jpg");
        assertNotNull(result);
    } //Test does not pass, as the image does not exist
>>>>>>> origin/master

    @Test
    public void testLoadDefaultImage_fileDoesNotExist() {
        BufferedImage result = imageProcessing.loadDefaultImage("path/to/nonexistentDefault.jpg");
        assertNull(result);
    }
}