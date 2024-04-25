package ru.aston.lesson_5.figures;

import java.util.Arrays;

public interface Figure {
    double getPerimeter();
    double getSquare();
    String getBackgroundColor();
    String getBorderColor();
    default double getPerimeter(double... sides) {
        return Arrays.stream(sides).sum();
    }

    default void makeСalculations() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getSquare());
        System.out.println("Цвет заливки: " + getBackgroundColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }

}
