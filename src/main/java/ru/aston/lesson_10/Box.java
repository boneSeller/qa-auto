package ru.aston.lesson_10;

import ru.aston.lesson_10.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.list = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<T> getList() {
        return list;
    }

    public void add(T... elements) {
        this.list.addAll(Arrays.asList(elements));
    }

    public void add(List<T> anotherList) {
        for (T fruit: anotherList)
             this.list.add(fruit);
    }

    public void clear() {
        if(list.isEmpty()) {
            System.out.println("Коробка пуста");
        } {
            list.clear();
            System.out.println("Коробка очищена");
        }
    }

    public float getWeight() {
        if(list.size() == 0) {
            return 0.0f;
        }
        return list.size() * list.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void replace(Box<T> anotherBox) {
        if(this == anotherBox) {
            return;
        }
        anotherBox.getList().addAll(this.list);
        this.list.clear();
    }
}
