package ru.aston.lesson_5.animals;

public class Dog extends Animal{
    static int count;
    public Dog(String name, int runMax, int swimMax){
        super(name, runMax, swimMax);
        count++;
    }

    @Override
    public void getCount() {
        System.out.println("Количесвто собак: " + count);
    }
}
