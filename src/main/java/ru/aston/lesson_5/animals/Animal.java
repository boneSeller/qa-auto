package ru.aston.lesson_5.animals;

public class Animal {
    private String name;
    private int runLimit;
    private int swimLimit;
    static int count;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public void run(int distance) {
        if (distance <= runLimit && distance > 0) {
            System.out.println(name + " пробежал дистанцию " + distance + " м.");
        } else if (distance > runLimit) {
            System.out.println(name + " не может пробежать такую дистанцию" + " м.");
        } else {
            System.out.println("Неверная дистанция");
        }
    }

    public void swim(int distance) {
        if (distance <= swimLimit && distance > 0) {
            System.out.println(name + " проплыл дистанцию " + distance + " м.");
        } else if (distance > swimLimit) {
            System.out.println(name + " не может проплыть такую дистанцию" + " м.");
        } else {
            System.out.println("Неверная дистанция");
        }
    }

    public void getCount() {
        System.out.println("Количество животных: " + count);
    }

    public String getName() {
        return name;
    }
}


