package ru.aston.lesson_7;

import ru.aston.lesson_7.myexception.MyArrayDataException;
import ru.aston.lesson_7.myexception.MyArraySizeException;
import ru.aston.lesson_7.myexception.MyException;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println(calculate(arr));
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    public static int calculate(String[][] data) {

        if (data.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                try {
                    sum += Integer.parseInt(data[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, data);
                }
            }
        }

        return sum;
    }
}
