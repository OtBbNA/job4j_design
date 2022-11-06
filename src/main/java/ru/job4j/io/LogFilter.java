package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            out.print(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            return in.lines()
                    .filter(i -> i.contains(" 404 "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
