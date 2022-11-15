package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader app = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean switcher = true;
            for (String i = app.readLine(); i != null; i = app.readLine()) {
                boolean status = i.contains("400") || i.contains("500");
                if ((status == switcher)) {
                    switcher = !switcher;
                    out.append(i.split(" ", 2)[1])
                            .append(';')
                            .append(switcher ? System.lineSeparator() : "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}