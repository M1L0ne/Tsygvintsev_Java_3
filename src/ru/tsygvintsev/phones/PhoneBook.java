package ru.tsygvintsev.phones;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public String addContact(String phoneNumber, String name) {
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

    public void removeContact(String name) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(name)) {
                contacts.remove(entry.getKey());
            }
        }
    }

    public String getContact(String name) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey() + " - " + entry.getValue();
            }
        }

        return "Не найдено";
    }

    public String checkContact(String text) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(text) || entry.getKey().equals(text)) {
                return entry.getKey() + " - " + entry.getValue();
            }
        }

        return "Не существует";
    }

    public int countContact() {
        int count = 0;

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            count++;
        }

        return count;
    }

    public String[] getContactArray(int choice) {
        String[] contactsArray = new String[contacts.size()];
        int i = 0;

        switch (choice) {
            case 1:
                for (Map.Entry<String, String> entry : contacts.entrySet()) {
                    contactsArray[i] = entry.getKey() + " - " + entry.getValue();
                    i++;
                }
                break;
            case 2:
                for (Map.Entry<String, String> entry : contacts.entrySet()) {
                    contactsArray[i] = entry.getKey();
                    i++;
                }
                break;
            case 3:
                for (Map.Entry<String, String> entry : contacts.entrySet()) {
                    contactsArray[i] = entry.getValue();
                    i++;
                }
                break;
            default:
                return contactsArray;
        }
        return contactsArray;
    }

    public String[] contactSearch(String namePart) {
        String[] foundContacts = new String[contacts.size()];
        int i = 0;
        String name;

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            name = entry.getValue();
            if (name.startsWith(namePart)) {
                foundContacts[i] = entry.getValue();
                i++;
            }
        }

        return foundContacts;
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            result = result + entry.getKey() + " - " + entry.getValue() + "; ";
        }
        return result;
    }

}
