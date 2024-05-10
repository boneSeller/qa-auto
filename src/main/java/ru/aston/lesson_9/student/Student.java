package ru.aston.lesson_9.student;

public class Student {
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
