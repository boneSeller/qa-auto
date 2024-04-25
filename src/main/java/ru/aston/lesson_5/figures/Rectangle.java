package ru.aston.lesson_5.figures;

public class Rectangle implements Figure{
    private double length;
    private double width;
    private String backgroundColor;
    private String borderColor;

    public Rectangle(double length, double width, String backgroundColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return getPerimeter(length, width) * 2;
    }

    @Override
    public double getSquare() {
        return length * width;
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
