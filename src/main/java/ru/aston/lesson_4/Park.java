package ru.aston.lesson_4;

import java.util.ArrayList;
import java.util.List;

/*3) Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости. */
public class Park {
    private List<Attraction> attractions;

    public Park() {
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String open, String close, double cost) {
        Attraction attraction = new Attraction(name, open, close , cost);
        this.attractions.add(attraction);
    }

    public void displayAttraction() {
        if(this.attractions.isEmpty()) {
            System.out.println("Нет доступных аттракционов");
        } else {
            for (Attraction o: this.attractions) {
                o.getInfo();
            }
        }
    }
    public class Attraction {
        private String name;
        private String open;
        private String close;
        private double cost;

        public Attraction(String name, String open, String close, double cost) {
            this.name = name;
            this.open = open;
            this.close = close;
            this.cost = cost;
        }

        public void getInfo() {
            System.out.println("Название аттракицона: " + name + " , работает с " + open + " до " + close  + " , стоимость билета: " + cost);
        }
    }
}
