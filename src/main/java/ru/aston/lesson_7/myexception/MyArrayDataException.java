package ru.aston.lesson_7.myexception;

import java.util.Arrays;

public class MyArrayDataException extends MyException{
    private int row;
    private int column;
    private String[][] array;
    public MyArrayDataException(int row, int column, String[][] array) {
        super("Невозможно преобразовать данные в ячейке: [" + row + " , " + column + "], Значение: " + array[row][column]);
        this.row = row;
        this. column = column;
        this.array = array;
    }
}
