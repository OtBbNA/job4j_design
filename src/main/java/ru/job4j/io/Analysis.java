package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader app = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean switcher = true;
            List<String> rsl = new ArrayList<>();
            String[] time;
            for (String i = app.readLine(); i != null; i = app.readLine()) {
                if ((i.contains("400") || i.contains("500")) && switcher) {
                    time = i.split(" ", 2);
                    out.print(time[1] + ';');
                    switcher = false;
                }
                if ((!i.contains("400") && !i.contains("500")) && !switcher) {
                    time = i.split(" ", 2);
                    out.println(time[1] + ';');
                    switcher = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis i = new Analysis();
        i.unavailable("./data/unavailableSource.csv", "./data/unavailableResult.csv");
    }
}