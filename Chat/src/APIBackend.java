import java.util.List;
public interface APIBackend {
    List<Contact> getContacts();

    void addContacts();

    User getUser();

    List<Message> getMessages(Chat chat);

    List<Chat> getChats(Contact contact);

    int getLikesNumber(Message message);
    int getDislikesNumber(Message message);

    List<Contact> getAlphabeticalContacts();
    List<Contact> getMembers(Chat chat);
}
