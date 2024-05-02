package ru.aston.lesson_7.myexception;

public class MyException extends RuntimeException{
    private String message;

    public MyException(String message) {
        super(message);
    }
}
