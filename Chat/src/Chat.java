import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Chat {
    private String name;
    private List<Contact> members;
    private List<Message> messages;

    public Chat(String newName, List<Contact> newMembers){
        this.members  = new ArrayList<>();
        this.members = newMembers;

        this.messages  = new LinkedList<>();

        this.name = newName;
    }

    public void setMembers(List<Contact> newMembers){
        this.members = newMembers;
    }
    public void setMessages(List<Message> newMessages){
        this.messages = newMessages;
    }
    public List<Message> getMessages() {
        return this.messages;
    }

    public List<Contact> getMembers(){
        return this.members;
    }

    public void addMember(Contact newMember){
        this.members.add(newMember);
    }

    public void removeMember(Contact memberToRemove){
        this.members.remove(memberToRemove);
    }
    public void addMessage(Message newMessage){
        this.messages.add(newMessage);
    }

    public List<Message> findMessages(String inputToFind){
        List<Message> foundMessages = new LinkedList<>();

        if(this.messages.isEmpty()){
            return foundMessages;
        }

        for(int i = 0; i < this.messages.size(); i++){
            String content = this.messages.get(i).getContent();
            if(content.contains(inputToFind)) {
                foundMessages.add(this.messages.get(i));
            }
        }

        return foundMessages;
    }

    /**
     * Function is used to set status flags of previously unread messages to true
     * Used when user enters a chat
     * All new messages will be automatically set to read
     */
    public void readMessages(){
        for(int i = this.messages.size() - 1; i >= 0; i--){
            if(!this.messages.get(i).isStatus()){
                this.messages.get(i).setStatus(true);
            }else{
                return;
            }
        }
    }
}
