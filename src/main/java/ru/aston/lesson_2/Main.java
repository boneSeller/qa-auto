package ru.aston.lesson_2;



public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(2,3);
        printColor(0);
        compareNumbers(3,3);
    }

    public static void printThreeWords() {
        String[] fruits = {"Orange", "Banana", "Apple"};
        for (String o: fruits) {
            System.out.println(o);
        }
    }

    public static void checkSumSign(int a, int b) {
        String answer = a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(answer);
    }

    public static void printColor(int value) {
        String answer = value <= 0 ? "Красный"  : value > 100 ? "Зеленый" : "Желтый";
        System.out.println(answer);
    }

    public static void compareNumbers(int a, int b) {
        String answer = a >= b ? "a>=b" : "a<b";
        System.out.println(answer);
    }
}
