import java.util.*;

public class User extends Contact{

    private List<Contact> contactList;
    private List<Contact> contactAlphabetical;

    public User(String name, int phoneNumber){
        super(name, phoneNumber);
        this.contactList = new ArrayList<>();
        this.contactAlphabetical = new LinkedList<>();
    }

    public void addContact(Contact newContact){
        this.contactList.add(newContact);

        this.contactAlphabetical = this.sortContactsAlphabeticallyEfficient();
    }

    public List<Contact> getContactAlphabetical(){
        return this.contactAlphabetical;
    }

    public List<Contact> getContactList() {
        return this.contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    //Print names for testing purposes
    public void printContactsNames(){
        for(int i = 0; i< this.contactList.size(); i++){
            System.out.println(this.contactList.get(i).getName());
        }
    }

    public List<Contact> sortContactsAlphabetically(){
        List<Contact> contactsSorted = new ArrayList<>();
        String[] names = new String[this.contactList.size()];

        for (int i = 0; i < this.contactList.size(); i++){
            names[i] = this.contactList.get(i).getName();
        }
        Arrays.sort(names);

        for(int i = 0; i < this.contactList.size(); i++){
            String nameToFind = names[i];
            for(int j = 0; j < this.contactList.size(); j++){
                String currentName = this.contactList.get(j).getName();
                if(nameToFind.equals(currentName)){
                    contactsSorted.add(this.contactList.get(j));
                }
            }
        }
        return contactsSorted;
    }

    public List<Contact> sortContactsAlphabeticallyEfficient(){
        List<Contact> sortedList = new ArrayList<>(this.contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        return sortedList;
    }

    public List<Contact> sortContactsOldestToNewest(){

        if(contactList==null){
            return null;
        }

        List<Contact> sortedList = new ArrayList<>(this.contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        return sortedList;
    }

    public List<Contact> sortContactsNewestToOldest(){

        if(contactList==null){
            return null;
        }

        List<Contact> sortedList = new ArrayList<>(this.contactList);

        sortedList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return -c1.getDateAdded().compareTo(c2.getDateAdded());
            }
        });
        return sortedList;
    }

}
