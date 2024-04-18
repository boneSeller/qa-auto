package ru.aston.lesson_4;

/*
* 1) Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.

Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль. */
public class Employee {
    private String fullName;
    private String post;
    private String email;
    private String number;
    private double salary;
    private int age;

    public Employee(String fullName, String post, String email, String number, double salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("ФИО: " + fullName + " , должность: " + post + " , email: " + email + " , телефон: "
                + number + " , зарплата: " + salary + " , возраст: " + age + ".");
    }

    public int getAge() {
        return age;
    }
}
