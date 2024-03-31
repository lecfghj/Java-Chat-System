import java.util.List;

/**
 * Implementation of an interface APIBackend to promote seamless integration with frontend
 */
public class BackendImplementation implements APIBackend{
    //Define current user
    User user;

    /**
     * Default constructor
     * @param userName represents user name
     * @param userPhoneNumber represents user phone number
     */
    public BackendImplementation(String userName, int userPhoneNumber){
        this.user = new User(userName, userPhoneNumber);
    }
    @Override
    /**
     * Implementation of getContacts method
     */
    public List<Contact> getContacts() {
        return this.user.getContactList();
    }

    /**
     * Implementation of addContacts method
     */
    @Override
    public void addContacts() {
    Contact contact1 = new Contact("Megan", 470275917);
    Contact contact2 = new Contact("Jonny", 402754381);
    Contact contact3 = new Contact("Liam Hall", 752748204);
    Contact contact4 = new Contact("Mary Smith", 28462847);
    Contact contact5 = new Contact("Jane Trigo", 34947281);
    Contact contact6 = new Contact("Jeremy Milne", 847284731);
    Contact contact7 = new Contact("Eric Hill", 492841321);
    Contact contact8 = new Contact("Alice Low", 374285932);
    Contact contact9 = new Contact("David Davis", 473748372);
    Contact contact10 = new Contact("Lee Miller", 347384111);
    user.addContact(contact1);
    user.addContact(contact2);
    user.addContact(contact3);
    user.addContact(contact4);
    user.addContact(contact5);
    user.addContact(contact6);
    user.addContact(contact7);
    user.addContact(contact8);
    user.addContact(contact9);
    user.addContact(contact10);
    }

    /**
     * Implementation of getUser method
     * @return current user
     */
    @Override
    public User getUser() {
        return this.user;
    }

    /**
     * Implementation of getMessages method
     * @param chat a chat to get messages from
     * @return list of message of a chat
     */
    @Override
    public List<Message> getMessages(Chat chat) {
        return chat.getMessages();
    }

    /**
     * Implementation of getChats method
     * @param contact contact to get chats of
     * @return list of chats of a contact
     */
    @Override
    public List<Chat> getChats(Contact contact) {
        return contact.getChats();
    }

    /**
     * Implementation of getLikesNumber method
     * @param message a message to count likes of
     * @return number of likes on a message
     */
    @Override
    public int getLikesNumber(Message message) {
        return message.countReaction(1);
    }

    /**
     * Implementation of getDislikesNumber method
     * @param message a message to count dislikes of
     * @return number of dislikes on a message
     */
    @Override
    public int getDislikesNumber(Message message) {
        return message.countReaction(-1);
    }

    /**
     * Implementation of getAlphabeticalContacts method
     * @return list of contacts sorted in alphabetical manner
     */
    @Override
    public List<Contact> getAlphabeticalContacts() {
        return this.user.getContactAlphabetical();
    }

    /**
     * Implementation of getMembers method
     * @param chat a chat to get members of
     * @return list of members of a chat
     */
    @Override
    public List<Contact> getMembers(Chat chat) {
        return chat.getMembers();
    }
}
