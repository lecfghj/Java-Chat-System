import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImageProcessing {

    public BufferedImage loadImage(String imagePath){
        BufferedImage image = null;

        try{
            File file = new File(imagePath);
            if(file.exists()){
                image = ImageIO.read(file);
            }else{
                System.out.println("Image not found.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred:" + e.getMessage());
        }

        return image;
    }

    public BufferedImage loadDefaultImage(String defaultImagePath){
        BufferedImage image = null;

        try{
            File defaultImage = new File(defaultImagePath);
            if(defaultImage.exists()){
                image = ImageIO.read(defaultImage);
            }
            else{
                System.out.println("Default image not found.");
            }
        }catch(IOException e){
            System.out.println("Error occurred:" + e.getMessage());
        }

        return image;
    }
}