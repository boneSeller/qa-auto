package ru.aston.lesson_5.dishes;

import ru.aston.lesson_5.animals.Animal;
import ru.aston.lesson_5.animals.Cat;

public class Plate {
    private int meals;


    public Plate(int meals) {
        this.meals = meals;
    }

    public boolean decrease(int meal) {
        if (meal < meals && meal > 0) {
            meals -= meal;
            return true;
        } else if (meal > meals) {
            System.out.println("Мало еды в миске, кот не будет есть.");
            return false;
        } else if (meal < 0) {
            System.out.println("Неверное число.");
            return false;
        } else {
            System.out.println("Миска не может быть пустой.");
            return false;
        }
    }

    public void increase(int meal) {
        meals += meal;
    }
}
