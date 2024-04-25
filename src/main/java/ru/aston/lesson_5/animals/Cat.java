package ru.aston.lesson_5.animals;
import ru.aston.lesson_5.dishes.Plate;

public class Cat extends Animal {
    static int count;
    private boolean satiety;
    private int appetite;

    public Cat(String name, int runMax, int swimMax) {
        super(name, runMax, swimMax);
        this.satiety = false;
        count++;
    }

    public Cat(String name, int runMax, int swimMax, int appetite) {
        super(name, runMax, swimMax);
        this.appetite = appetite;
        this.satiety = false;
        count++;
    }

    @Override
    public void swim(int dinstance) {
        System.out.println("Коты не умеют плавать.");
    }

    @Override
    public void getCount() {
        System.out.println("Количество котов:" + count);
    }

    //Задание №1.5
    public void eat(Plate plate) {
        if (!isSatiety()) {
            if (plate.decrease(this.appetite)) {
                this.satiety = true;
                System.out.println(getName() + " кот насытился.");
            }
        } else {
            System.out.println(getName() + " кот сытый.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}
