package ru.aston.lesson_4;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan Ivanov", "Engineer", "ivan@nomail.ru", "+788092123121", 13000.0, 35);
        employees[1] = new Employee("Peter Petrov", "Engineer", "pit@nomail.ru", "+788092123122", 15000.0, 40);
        employees[2] = new Employee("Sasha Sashov", "Engineer", "sasha@nomail.ru", "+788092123123", 17000.0, 37);
        employees[3] = new Employee("Vova Vovov", "Engineer", "vova@nomail.ru", "+788092123124", 20000.0, 43);
        employees[4] = new Employee("Lexa Lexov", "Engineer", "ivan@nomail.ru", "+788092123125", 15000.0, 39);

        for(int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].getInfo();
            }
        }
    }
}
