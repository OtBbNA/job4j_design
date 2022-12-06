package ru.job4j.io;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        validation(argsName);
        List<String> line = new ArrayList<>();
        var scanner = new Scanner(new FileInputStream(argsName.get("path"))).useDelimiter("\r\n");
        while (scanner.hasNext()) {
            line.add(scanner.next());
        }
        ArrayList<Integer> index = getIndex(line.get(0), argsName.get("delimiter"), argsName.get("filter"));
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(argsName.get("out"))))) {
            for (int i = 0; i < line.size(); i++) {
                String[] splitLine = line.get(i).split(argsName.get("delimiter"));
                for (int k = 0; k < index.size(); k++) {
                    out.append(splitLine[index.get(k)]).append(!(k == index.size() - 1) ? ";" : System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static ArrayList<Integer> getIndex(String headString, String delimiter, String filter) {
        String[] filterNames = filter.split(",");
        String[] headNames = headString.split(delimiter);
        ArrayList<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < filterNames.length; i++) {
            for (int j = 0; j < headNames.length; j++) {
                if (filterNames[i].equals(headNames[j])) {
                    rsl.add(j);
                }
            }
        }
        return rsl;
    }

    public static void validation(ArgsName argsName) {
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("Source file must be in .csv format");
        }
        if (argsName.get("delimiter").length() > 1) {
            throw new IllegalArgumentException("Separator must be one character long");
        }
        if (!"stdout".equals(argsName.get("out")) && !argsName.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException("Target file must be in .csv format");
        }
    }

}