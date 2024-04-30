package ru.aston.lesson_6.management;

public class AppData {
    private String[] header;

    private int[][] data;

    private String regex;

    private String filename;

    public AppData(String[] header, int[][] data, String regex, String filename) {
        this.header = header;
        this.data = data;
        this.regex = regex;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public String getRegex() {
        return regex;
    }

}
