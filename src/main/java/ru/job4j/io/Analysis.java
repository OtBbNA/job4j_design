package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader app =
                     new BufferedReader(
                             new FileReader(source))) {
            boolean switcher = true;
            List<String> rsl = new ArrayList<>();
            String[] time;
            for (String i = app.readLine(); i != null; i = app.readLine()) {
                if ((i.contains("400") || i.contains("500")) && switcher) {
                    time = i.split(" ", 2);
                    rsl.add(time[1]);
                    switcher = false;
                }
                if ((!i.contains("400") && !i.contains("500")) && !switcher) {
                    time = i.split(" ", 2);
                    rsl.add(time[1]);
                    switcher = true;
                }
            }
            unavailableOutput(target, rsl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unavailableOutput(String target, List<String> readLine) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            byte r = 0;
            for (int i = 0; i < readLine.size(); i++) {
                    out.print(readLine.get(i));
                    out.print(";");
                    r++;
                if (r >= 2) {
                    out.println();
                    r = 0;
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