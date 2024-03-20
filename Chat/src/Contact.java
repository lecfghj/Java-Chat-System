import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

public class Contact implements Serializable {
    private String name;
    private int phoneNumber;
    private final LocalDateTime dateAdded;
    private ImageIcon profileImage;
    // Container for most recent messages sent, has most recent message at the end of the list and the least recent at the start
    private List<Message> lastThreeMessages;

    /**
     * Default constructor for Contact object
     * Initializes the contact with the current date as dateAdded and defaultImage as profileImage
     * Default image path is src/defaultImage.png
     */
    public Contact(){
        this.dateAdded = LocalDateTime.now();
        this.profileImage = new ImageIcon("src/defaultImage.png");

        this.lastThreeMessages = new LinkedList<>();
    }

    public List<Message> getLastThreeMessages() {
        return this.lastThreeMessages;
    }

    public LocalDateTime getDateAdded() {
        return this.dateAdded;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ImageIcon getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(ImageIcon profileImage) {
        this.profileImage = profileImage;
    }

    public void sendMessage(String content){
        // Initialize new message
        Message newMessage = new Message(this);
        newMessage.setContent(content);
        newMessage.setStatus(false);

        if(this.lastThreeMessages.size() < 3){ // If list has less than 3 messages
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }else{ // If list has three messages
            ((LinkedList<Message>)this.lastThreeMessages).removeFirst(); //Removes the first element from the list
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }
    }
    
    
    public static void main(String[] args){

    }
}
