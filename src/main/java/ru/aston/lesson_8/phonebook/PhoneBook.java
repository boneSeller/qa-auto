package ru.aston.lesson_8.phonebook;

import java.util.*;

public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new HashSet<>(Arrays.asList(phoneNumber)));
        }
        phoneBook.get(surname).add(phoneNumber);
    }

    public void get(String surname) {
        System.out.println(phoneBook.get(surname));
    }
}
