import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Contact implements Serializable {
    private String name;
    private int phoneNumber;
    private final LocalDateTime dateAdded;
    private BufferedImage profileImage;

    /**
     * Default constructor for Contact object
     * Initializes the contact with the current date as dateAdded and defaultImage as profileImage
     * Default image path is src/defaultImage.png
     */
    public Contact(){
        ImageProcessing ip = new ImageProcessing();

        dateAdded = LocalDateTime.now();
        profileImage = ip.loadImage("src/defaultImage.png");
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BufferedImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(BufferedImage profileImage) {
        this.profileImage = profileImage;
    }

    public static void main(String[] args){

    }
}
