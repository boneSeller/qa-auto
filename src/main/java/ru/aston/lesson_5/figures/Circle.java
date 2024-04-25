package ru.aston.lesson_5.figures;

import java.util.Map;

public class Circle implements Figure{
    private double radius;
    private String backgroundColor;
    private String borderColor;
    public Circle(double radius, String backgroundColor, String borderColor) {
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return Math.floor(2 * Math.PI * radius);
    }

    @Override
    public double getSquare() {
        return Math.floor(Math.PI * Math.pow(radius, 2));
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
