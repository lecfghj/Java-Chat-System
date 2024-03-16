import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Message {
    private String content;
    private HashMap<Contact, Integer> reaction;
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

    public HashMap<Contact, Integer> getReaction() {
        return this.reaction;
    }

    public void setReaction(Contact author, Integer reactionID) {
        if(author != null && reactionID != null){
            this.reaction.put(author, reactionID);
        }else{
            System.out.println("Parameters cannot be null");
        }

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