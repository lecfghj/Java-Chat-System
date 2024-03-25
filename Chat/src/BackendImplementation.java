import java.util.List;

public class BackendImplementation implements APIBackend{

    User user;

    public BackendImplementation(String userName, int userPhoneNumber){
        this.user = new User(userName, userPhoneNumber);
    }
    @Override
    public List<Contact> getContacts() {
        return this.user.getContactList();
    }

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

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public List<Message> getMessages(Chat chat) {
        return chat.getMessages();
    }

    @Override
    public List<Chat> getChats(Contact contact) {
        return contact.getChats();
    }

    @Override
    public int getLikesNumber(Message message) {
        return message.countReaction(1);
    }

    @Override
    public int getDislikesNumber(Message message) {
        return message.countReaction(-1);
    }

    @Override
    public List<Contact> getAlphabeticalContacts() {
        return this.user.getContactAlphabetical();
    }

    @Override
    public List<Contact> getMembers(Chat chat) {
        return chat.getMembers();
    }
}
