package ru.aston.lesson_9;

import ru.aston.lesson_9.student.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(n -> n % 2 == 0).count());
        List<String> list = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        System.out.println(list.stream().filter(n -> n.contains("High")).count());
        System.out.println(list.stream().findFirst().orElse("0"));
        System.out.println(list.stream().reduce((first, second) -> second).orElse("0"));

        List<String> list1 = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        System.out.println(Arrays.toString(list1.stream()
                .sorted(Comparator.comparing(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new)));

        Student[] students = {
                new Student("Вася", 25, "м"),
                new Student("Филя", 17, "м"),
                new Student("Лёша", 23, "м"),
                new Student("Федот", 28, "м"),
                new Student("Катя", 28, "ж"),
                new Student("Ира", 28, "ж"),
        };

        System.out.println(Arrays.stream(students).filter(s -> s.getSex() == "м").mapToInt(Student::getAge).average());
        System.out.println(Arrays.stream(students)
                .filter(s -> s.getSex() == "м")
                .filter(s -> 27 >= s.getAge() && s.getAge() >= 18)
                .map(s -> s.getName()).collect(Collectors.joining(", ", "Пизывники: ", ".")));

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String input;
        List<String> list2 = new ArrayList<>();
        while (!(input = sc.nextLine()).isEmpty()) {
            list2.add(input);
        }
        list2.stream().filter(l -> l.charAt(0) == 'f').forEach(System.out::println);
    }
}
