import java.util.List;

/**
 * APIBackend interface designed to promote seamless integration of backend code with frontend
 */
public interface APIBackend {
    /**
     * Gets a list of contacts
     * @return list of contacts
     */
    List<Contact> getContacts();

    /**
     * Adds contacts
     */
    void addContacts();

    /**
     * Gets current user
     * @return user
     */
    User getUser();

    /**
     * Gets messages from a chat
     * @param chat a chat to get messages from
     * @return messages list
     */
    List<Message> getMessages(Chat chat);

    /**
     * Gets chats of a contact
     * @param contact contact to get chats of
     * @return list of chats
     */
    List<Chat> getChats(Contact contact);

    /**
     * Gets number of likes on a message
     * @param message a message to count likes of
     * @return number of likes
     */
    int getLikesNumber(Message message);

    /**
     * Gets number of dislikes on a message
     * @param message a message to count dislikes of
     * @return number of dislikes
     */
    int getDislikesNumber(Message message);

    /**
     * Gets list of contacts sorted in alphabetical manner
     * @return alphabetically sorted list of contacts
     */
    List<Contact> getAlphabeticalContacts();

    /**
     * Gets members of a chat
     * @param chat a chat to get members of
     * @return list of members
     */
    List<Contact> getMembers(Chat chat);
}
