package ru.aston.lesson_5.figures;

public class Triangle implements Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String backgroundColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return getPerimeter(sideA, sideB, sideC);
    }

    @Override
    public double getSquare() {
        double s = (sideA * sideB) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
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
