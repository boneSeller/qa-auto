package ru.aston.lesson_6;

import ru.aston.lesson_6.management.AppData;

import static ru.aston.lesson_6.management.FileManagement.read;
import static ru.aston.lesson_6.management.FileManagement.save;

public class Main {
    public static void main(String[] args) {
        String[] header = {"Столбец 1", "Столбец 2", "Столбец 3"};

        int[][] data = {{23,64,56}, {23,64,56}};

        AppData appData = new AppData(header, data, ";", "demo.csv");

        save(appData);

        read(appData);
    }

}
