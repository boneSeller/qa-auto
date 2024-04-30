package ru.aston.lesson_6.management;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManagement {

    public static void save(AppData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(data.getFilename()))) {
            writer.write(String.join(data.getRegex(), data.getHeader()));
            writer.newLine();

            for (int[] row : data.getData()) {
                writer.write(String.join(data.getRegex(), Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(AppData data) {
        try (BufferedReader reader = new BufferedReader(new FileReader(data.getFilename()))) {
            String[] header = reader.readLine().split(data.getRegex());

            List<int[]> text = new ArrayList<>();

            String line;

            while ((line = reader.readLine()) != null) {
                text.add(Arrays.stream(line.split(data.getRegex())).mapToInt(Integer::parseInt).toArray());
            }

            // Вывод заголовка и данных в консоль
            for (String h : header) {
                System.out.print(h + "\t");
            }

            System.out.println();

            for (int[] row : text) {
                for (int d : row) {
                    System.out.print(d + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


