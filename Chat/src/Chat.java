import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Chat {
    private List<Contact> members;
    private List<Message> messages;

    public Chat(){
        members  = new ArrayList<>();
        messages  = new LinkedList<>();
    }


    public List<Message> findMessages(String inputToFind){
        List<Message> foundMessages = new LinkedList<>();

        if(messages.isEmpty()){
            return foundMessages;
        }

        for(int i = 0; i < messages.size(); i++){
            String content = messages.get(i).getContent();
            if(content.contains(inputToFind)) {
                foundMessages.add(messages.get(i));
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
        for(int i = messages.size() - 1; i >= 0; i--){
            if(!messages.get(i).isStatus()){
                messages.get(i).setStatus(true);
            }else{
                return;
            }
        }
    }

}
