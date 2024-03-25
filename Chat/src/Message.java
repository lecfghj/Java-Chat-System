import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Message {
    private String content;
    private HashMap<Contact, Integer> reaction; //1 is used to represent like; -1 is used for dislike
    private Contact author;
    //Status flag is used to determine whether message was read or not; false - not read, true - read
    private boolean status;
    private final LocalDateTime dateAdded;

    public Message(){
        this.reaction = new HashMap<>();
        this.status = false;
        this.dateAdded = LocalDateTime.now();
    }

    public Message(Contact author){
        this.author = author;
        this.reaction = new HashMap<>();
        this.status = false;
        this.dateAdded = LocalDateTime.now();
    }

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

    public int countReaction(Integer reactionID){
       int count = 0;

       for(HashMap.Entry<Contact, Integer> entry : reaction.entrySet()){
           if(entry.getValue().equals(reactionID)) count++;
       }

       return count;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact getAuthor() {
        return this.author;
    }

    public void setAuthor(Contact author) {
        this.author = author;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}