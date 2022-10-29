package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                out.write(("4 * " + i + " = " + 4 * i).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}