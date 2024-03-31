import java.io.*;
import java.util.*;

/**
 * Class User represents user in the Chat
 * Extends Contact class
 */
public class User extends Contact{
    // Define fields
    private static final long serialVersionUID = 1L;
    private List<Contact> contactList;
    private List<Contact> contactAlphabetical;

    /**
     * Default constructor
     * @param name represents user's name
     * @param phoneNumber represents user's phone number
     */
    public User(String name, int phoneNumber){
        super(name, phoneNumber);
        this.contactList = new ArrayList<>();
        this.contactAlphabetical = new LinkedList<>();
    }

    /**
     * addContact function adds new contact to contacts list
     * @param newContact represents contact to add
     */
    public void addContact(Contact newContact){
        // Add new contact to contacts list
        this.contactList.add(newContact);
        // Sort alphabetically and store in contacts list alphabetical
        this.contactAlphabetical = this.sortContactsAlphabeticallyEfficient();
    }

    /**
     * Getter for contactAlphabetical list
     * @return contactAlphabetical
     */
    public List<Contact> getContactAlphabetical(){
        return this.contactAlphabetical;
    }

    /**
     * Getter for contacts' list
     * @return contactList
     */
    public List<Contact> getContactList() {
        return this.contactList;
    }

    /**
     * Setter for contacts list
     * @param contactList represents new contact list
     */
    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    /**
     * Function for sorting contacts list in alphabetical order
     * @return sorted contacts list
     */
    public List<Contact> sortContactsAlphabetically(){
        // Create a new list to store sorted contacts in
        List<Contact> contactsSorted = new ArrayList<>();
        // Create an array to store names
        String[] names = new String[this.contactList.size()];
        // Add all names from contacts list to array of names
        for (int i = 0; i < this.contactList.size(); i++){
            names[i] = this.contactList.get(i).getName();
        }
        // Sort array with names
        Arrays.sort(names);
        // Iterate through each name in sorted array of names
        for(int i = 0; i < this.contactList.size(); i++){
            String nameToFind = names[i];
            // Find a contact with same name in contacts list
            for(int j = 0; j < this.contactList.size(); j++){
                String currentName = this.contactList.get(j).getName();
                // Add found contact to sorted list
                if(nameToFind.equals(currentName)){
                    contactsSorted.add(this.contactList.get(j));
                }
            }
        }
        // Return sorted list
        return contactsSorted;
    }

    /**
     * Function to sort contacts in alphabetical order
     * @return sorted list of contacts
     */
    public List<Contact> sortContactsAlphabeticallyEfficient(){
        // If list is null terminate function
        if(contactList==null){
            return null;
        }
        // Copy contacts list to new list
        List<Contact> sortedList = new ArrayList<>(this.contactList);
        // Sort using comparator to compare objects by specific fields
        sortedList.sort(new Comparator<Contact>() {
            @Override
            // Use name field for comparison
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        // Return sorted list
        return sortedList;
    }

    /**
     * Function to sort contacts list from oldest to newest
     * @return sorted list
     */
    public List<Contact> sortContactsOldestToNewest(){
        // If list is null terminate function
        if(contactList==null){
            return null;
        }
        // Copy contacts into new list
        List<Contact> sortedList = new ArrayList<>(this.contactList);
        // Sort using comparator to compare objects by specific fields
        sortedList.sort(new Comparator<Contact>() {
            @Override
            // Use dateAdded field for comparison
            public int compare(Contact c1, Contact c2) {
                return c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        // Return sorted list
        return sortedList;
    }

    /**
     * Function to sort contacts list from newest to oldest
     * @return sorted list
     */
    public List<Contact> sortContactsNewestToOldest(){
        // If list is null terminate function
        if(contactList==null){
            return null;
        }
        // Copy contacts into new list
        List<Contact> sortedList = new ArrayList<>(this.contactList);
        // Sort using comparator to compare objects by specific fields
        sortedList.sort(new Comparator<Contact>() {
            @Override
            // Use dateAdded field for comparison
            public int compare(Contact c1, Contact c2) {
                // Return negative result of compareTo to reverse order of sorting
                return -c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        // Return sorted list
        return sortedList;
    }

    /**
     * Function saves user data to a file
     * @param fileName name of the file to sava data to
     */
    public void saveData(String fileName){
        // Initialize output streams
        FileOutputStream fos = null;
        ObjectOutputStream oos;
        try {
            // Open output streams for given file
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            // Write user object to chosen file
            oos.writeObject(this);
        // Catch any exceptions that occur
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // Close streams
            try{
                if(fos != null){
                    fos.close();
                }
            }catch (IOException b){
                b.printStackTrace();
            }
        }
    }

    /**
     * Loads user data from a file
     * @param fileName name of the file to read the data from
     * @return loaded user
     */
    public static User loadData(String fileName){
    // Initialize user object to load data to
    User loadedUser;
    // Initialize input streams
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    try{
        // Open input streams for given file
        fis = new FileInputStream(fileName);
        ois = new ObjectInputStream(fis);
        // Read object from a file and assign it to loadedUser
        loadedUser = (User)ois.readObject();
    // Catch any exceptions that may occur
    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    } finally{
    // Close input streams
        try{
            if(fis != null){
                fis.close();
            }
            if(ois != null){
                ois.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    // Return loaded user
        return loadedUser;
    }

}
