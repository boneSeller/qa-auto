package ru.aston.lesson_10;

import ru.aston.lesson_10.fruits.Apple;
import ru.aston.lesson_10.fruits.Orange;

public class MainApp {
    public static void main(String[] args) {
        Box<Apple> boxWithApple = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> boxWithApple2 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple());
        Box<Orange> boxWithOrange = new Box<>(new Orange(), new Orange());

        System.out.println(boxWithApple.getWeight());
        System.out.println(boxWithApple2.getWeight());
        System.out.println(boxWithOrange.getWeight());
        System.out.println(boxWithApple.compare(boxWithOrange));
        System.out.println(boxWithApple.compare(boxWithApple2));

        boxWithApple.replace(boxWithApple2);
        System.out.println(boxWithApple.getList());
        System.out.println(boxWithApple2.getList());
    }
}
