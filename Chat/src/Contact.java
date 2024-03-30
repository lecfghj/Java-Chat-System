import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Contact implements Serializable {
    private String name;
    private int phoneNumber;
    private final LocalDateTime dateAdded;
    private ImageIcon profileImage;
    // Container for most recent messages sent, has most recent message at the end of the list and the least recent at the start
    private List<Message> lastThreeMessages;
    private List<Chat> chats;

    /**
     * Default constructor for Contact object
     * Initializes the contact with the current date as dateAdded and defaultImage as profileImage
     * Default image path is src/defaultImage.png
     */
//    public Contact(){
//        this.dateAdded = LocalDateTime.now();
//        this.profileImage = new ImageIcon("src/defaultImage.png");
//
//        this.lastThreeMessages = new LinkedList<>();
//        this.chats = new LinkedList<>();
//    }
    public Contact(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateAdded = LocalDateTime.now();
        this.profileImage = new ImageIcon("src/defaultImage.png");

        this.lastThreeMessages = new LinkedList<>();
        this.chats = new LinkedList<>();
    }
    public void createChat(String chatName, List<Contact> members){
        Chat newChat = new Chat(chatName, members);

        newChat.addMember(this);
        Iterator<Contact> iterator = newChat.getMembers().iterator();
        while(iterator.hasNext()){
            Contact current = iterator.next();
            current.addChat(newChat);
        }
    }
    public List<Chat> getChats(){
        return this.chats;
    }
    public void addChat(Chat newChat){
        this.chats.add(newChat);
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

    public void sendMessage(String content, Chat destination){
        // Initialize new message
        Message newMessage = new Message(this);
        newMessage.setContent(content);
        newMessage.setStatus(false);

        if(chats.contains(destination)){
            destination.addMessage(newMessage);
        }else{
            return;
        }

        if(this.lastThreeMessages.size() < 3){ // If list has less than 3 messages
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }else{ // If list has three messages
            this.lastThreeMessages.remove(0); //Removes the first element from the list
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }
    }
    
    
    public static void main(String[] args){

    }
}
