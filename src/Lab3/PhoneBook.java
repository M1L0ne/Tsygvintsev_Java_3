package Lab3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts;

    public PhoneBook () {
        this.contacts = new HashMap<>();
    }

    public String addContact (String phoneNumber, String name) {
        String previousNumber = null;

        for (Map.Entry<String, String> entry: contacts.entrySet()) {
            if (entry.getValue().equals(name)) {
                previousNumber = entry.getKey();
                contacts.remove(previousNumber);
            }
        }

        contacts.put(phoneNumber, name);

        return previousNumber;
    }

}
