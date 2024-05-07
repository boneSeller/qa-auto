package ru.aston.lesson_8;

import ru.aston.lesson_8.phonebook.PhoneBook;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Слово", "Слово", "Река", "Океан", "Игрок", "Дом", "Снег",
                "Река", "Океан", "Лавина", "Собор", "Жизнь", "Океан", "Лавина",
                "Собор"
        };

        counter(words);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Пупкин", "+375231231231");
        phoneBook.add("Пупкин", "+3752312312231");
        phoneBook.get("Пупкин");

    }

    public static void counter(String[] arr) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String o : arr) {
            hm.put(o, hm.getOrDefault(o, 0) + 1);
        }
        System.out.println(hm);
    }
}
