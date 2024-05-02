package ru.aston.lesson_7.myexception;

import java.util.Arrays;

public class MyArraySizeException extends MyException{

    public MyArraySizeException() {
        super("Размер масссива не 4x4.");
    }

}
