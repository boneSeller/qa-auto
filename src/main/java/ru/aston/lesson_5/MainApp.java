package ru.aston.lesson_5;

import ru.aston.lesson_5.animals.Animal;
import ru.aston.lesson_5.animals.Cat;
import ru.aston.lesson_5.animals.Dog;
import ru.aston.lesson_5.dishes.Plate;
import ru.aston.lesson_5.figures.Circle;
import ru.aston.lesson_5.figures.Figure;
import ru.aston.lesson_5.figures.Rectangle;
import ru.aston.lesson_5.figures.Triangle;

public class MainApp {
    public static void main(String[] args) {
        //Задание №1.1 - 1.4
        Animal[] animals = {
                new Animal("Черный", 150, 170),
                new Cat("Белый", 120, 180),
                new Dog("Серый", 160, 160),
                new Dog("Синий", 160, 160)
        };

        for (Animal a : animals) {
            a.run(150);
            a.swim(170);
            a.getCount();
        }

        //Задание №1.5 Задача про котов и тарелки с едой.
        Cat[] cats = {
                new Cat("Черный", 150, 170, 25),
                new Cat("Белый", 120, 180, 30),
                new Cat("Серый", 160, 160, 40),
                new Cat("Синий", 160, 160, 150)
        };

        Plate plate = new Plate(120);
        for (Cat c : cats) {
            c.eat(plate);
        }

        plate.increase(150);

        for (Cat c : cats) {
            c.eat(plate);
        }

        //Задача №2 Расчет периметра и площади геометрических фигур
        Figure[] figures = {
                new Rectangle(4, 5, "red", "blue"),
                new Triangle(3, 4, 5, "green", "yellow"),
                new Circle(2, "blue", "red")
        };

        for (Figure figure : figures) {
            figure.makeСalculations();
        }
    }
}
