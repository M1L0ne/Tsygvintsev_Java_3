package Lab3;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private String phoneNumber;
    private String name;

    public PhoneBook (String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }


}
