import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;

/**
 * Message class represents message in a chat program
 * It implements Serializable interface
 */
public class Message implements Serializable {
    // Define class fields
    private String content;
    private HashMap<Contact, Integer> reaction; //1 is used to represent like; -1 is used for dislike
    private Contact author;
    //Status flag is used to determine whether message was read or not; false - not read, true - read
    private boolean status;
    private final LocalDateTime dateAdded;

    /**
     * Default constructor for Message
     */
//    public Message(){
//        this.reaction = new HashMap<>();
//        this.status = false;
//        this.dateAdded = LocalDateTime.now();
//    }

    /**
     * Default constructor for Message class
     * @param author represents author of a message
     */
    public Message(Contact author){
        this.author = author;
        this.reaction = new HashMap<>();
        this.status = false;
        this.dateAdded = LocalDateTime.now();
    }

    /**
     * Getter for reactions
     * @return reactions
     */
    public HashMap<Contact, Integer> getReactions() {
        return this.reaction;
    }

    /**
     * setReaction function sets the reaction of a given author for the message
     * @param author the contact representing the author of the reaction
     * @param reactionID an integer representing reaction ID: 1 represents like, -1 represents dislike
     */
    public void setReaction(Contact author, Integer reactionID) {
        if(author != null && reactionID != null){
            this.reaction.put(author, reactionID);
        }else{
            System.out.println("Parameters cannot be null");
        }

    }

    /**
     * countReaction function counts reaction with passed ID in reactions map
     * @param reactionID represents reaction ID
     * @return number of reactions of passed type
     */
    public int countReaction(Integer reactionID){
        // Initialize count at zero
        int count = 0;
        // Iterate through each element in a map
        for(HashMap.Entry<Contact, Integer> entry : reaction.entrySet()){
           // If current ID equals passed ID, increment count
            if(entry.getValue().equals(reactionID)) count++;
        }
        // Return number of reactions with passed ID
        return count;
    }

    /**
     * Getter for content
     * @return content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Setter for content
     * @param content represents content of a message
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter for author of a message
     * @return author
     */
    public Contact getAuthor() {
        return this.author;
    }

    /**
     * Setter for author of a message
     * @param author represents author of a message
     */
    public void setAuthor(Contact author) {
        this.author = author;
    }

    /**
     * Getter for status of a message
     * @return status
     */
    public boolean isStatus() {
        return this.status;
    }

    /**
     * Setter for a status of a message
     * @param status represents read/unread status of a message
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}