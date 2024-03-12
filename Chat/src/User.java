import java.util.*;
import java.util.Collection;

public class User extends Contact{

    private List<Contact> contactList;

    public User(){
        super();
        contactList = new ArrayList<>();
    }

    public void addContact(Contact newContact){
        contactList.add(newContact);
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    //Print names for testing purposes
    public void printContactsNames(){
        for(int i = 0; i<contactList.size(); i++){
            System.out.println(contactList.get(i).getName());
        }
    }

    public List<Contact> sortContactsAlphabetically(){
        List<Contact> contactsSorted = new ArrayList<>();
        String[] names = new String[contactList.size()];

        for (int i = 0; i < contactList.size(); i++){
            names[i] = contactList.get(i).getName();
        }
        Arrays.sort(names);

        for(int i = 0; i < contactList.size(); i++){
            String nameToFind = names[i];
            for(int j = 0; j < contactList.size(); j++){
                String currentName = contactList.get(j).getName();
                if(nameToFind.equals(currentName)){
                    contactsSorted.add(contactList.get(j));
                }
            }
        }
        return contactsSorted;
    }

    public List<Contact> sortContactsAlphabeticallyEfficient(){
        List<Contact> sortedList = new ArrayList<>(contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        return sortedList;
    }

    public List<Contact> sortContactsNewestToOldest(){
        List<Contact> sortedList = new ArrayList<>(contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        return sortedList;
    }

    public List<Contact> sortContactsOldestToNewest(){
        List<Contact> sortedList = new ArrayList<>(contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return -c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        return sortedList;
    }

}
