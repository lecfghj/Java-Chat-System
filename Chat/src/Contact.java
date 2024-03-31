import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contact class represents contact in a chat
 * It implements Serializable interface
 */
public class Contact implements Serializable {
    // Define Contact class fields
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
     * @param name
     * @param phoneNumber
     */
    public Contact(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        // Set dateAdded to current time
        this.dateAdded = LocalDateTime.now();
        // Set profile image to default image
        this.profileImage = new ImageIcon("src/defaultImage.png");

        this.lastThreeMessages = new LinkedList<>();
        this.chats = new LinkedList<>();
    }

    /**
     * createChat function creates new chat object and adds passed members along with the contact creating the chat
     * @param chatName represents chat name
     * @param members represent members chosen by this contact (does NOT include this contact)
     * @return new chat
     */
    public Chat createChat(String chatName, List<Contact> members){
        // Create a chat object with passed name and members
        Chat newChat = new Chat(chatName, members);

        // Add this contact to the new chat
        newChat.addMember(this);
        // Add new chat to each members' chats list
        Iterator<Contact> iterator = newChat.getMembers().iterator();
        while(iterator.hasNext()){
            Contact current = iterator.next();
            current.addChat(newChat);
        }
        // Return created chat
        return newChat;
    }

    /**
     * Getter for chats list
     * @return chats list
     */
    public List<Chat> getChats(){
        return this.chats;
    }

    /**
     * addChat method adds new chat to chats list
     * @param newChat represents chat to add
     */
    public void addChat(Chat newChat){
        this.chats.add(newChat);
    }

    /**
     * Getter for last three messages list
     * @return last three messages list
     */
    public List<Message> getLastThreeMessages() {
        return this.lastThreeMessages;
    }

    /**
     * Getter for date added
     * @return date added
     */
    public LocalDateTime getDateAdded() {
        return this.dateAdded;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for name
     * @param name represents new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for phone number
     * @return phone number
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Setter for phone number
     * @param phoneNumber represents phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for profile image
     * @return profile image
     */
    public ImageIcon getProfileImage() {
        return this.profileImage;
    }

    /**
     * Setter for profile image
     * @param profileImage represents new profile image
     */
    public void setProfileImage(ImageIcon profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * sendMessage function sends message to passed chat with passed content as parameters
     * @param content represents content of a message to send
     * @param destination represents a chat to send the message to
     */
    public void sendMessage(String content, Chat destination){
        // Initialize new message
        Message newMessage = new Message(this);
        // Set content
        newMessage.setContent(content);
        // Set read flag to false
        newMessage.setStatus(false);
        // Check if contact is a member of destination chat
        if(chats.contains(destination)){
            // If destination chat is valid add a message
            destination.addMessage(newMessage);
        }else{
            //If not a valid chat, terminate
            return;
        }

        // Manage last three message list
        if(this.lastThreeMessages.size() < 3){ // If list has less than 3 messages
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }else{ // If list has three messages
            this.lastThreeMessages.remove(0); //Removes the first element from the list
            this.lastThreeMessages.add(newMessage); //Adds new element to the end of the list
        }
    }

    /**
     * getChatByName returns a chat with passed name if it exists
     * @param chatName represents name of the chat to find
     * @return chat if it exists, null otherwise
     */
    public Chat getChatByName(String chatName){

        for(int i = 0; i < this.chats.size(); i++){
            if(this.chats.get(i).getName().equals(chatName)){
                return this.chats.get(i);
            }
        }
        return null;
    }
    

    public static void main(String[] args){
        User u1 = new User("A", 2333456);
        Contact c1 = new Contact("B", 76479953);
        Contact c2 = new Contact("C", 96421953);
        u1.addContact(c1);
        u1.addContact(c2);
        List<Contact> members = new ArrayList<>();
        members.add(c1);
        members.add(c2);

        Chat newChat = u1.createChat("TestChat", members);
        c1.sendMessage("Hi there!", newChat);
        u1.sendMessage("Good morning!", newChat);

        u1.saveData("TestSave");
        User u2 = User.loadData("TestSave");

        List<Contact> cl = u2.getContactList();
        for(int i = 0; i < cl.size(); i++){
            String thisName = cl.get(i).getName();
            System.out.println(thisName);
        }

        System.out.println(u2.getProfileImage());
        System.out.println(u1.getProfileImage());

        Chat loadedChat = u2.getChats().get(0);

        System.out.println(loadedChat.getMessages().get(0).getContent());
        System.out.println(loadedChat.getMessages().get(1).getContent());
    }
}
