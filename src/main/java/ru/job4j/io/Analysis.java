package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader app = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean switcher = true;
            String[] time;
            for (String i = app.readLine(); i != null; i = app.readLine()) {
                if (((i.contains("400") || i.contains("500")) && switcher)
                    || ((!i.contains("400") && !i.contains("500")) && !switcher)) {
                    time = i.split(" ", 2);
                    out.append(time[1] + ';');
                    switcher = !switcher;
                    if (switcher) {
                        out.println();
                    }
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