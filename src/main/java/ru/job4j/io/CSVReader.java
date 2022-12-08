package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        validation(argsName);
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        try (var scanner = new Scanner(new FileInputStream(path)).useDelimiter("\r\n")) {
            List<String> line = new ArrayList<>();
            while (scanner.hasNext()) {
                line.add(scanner.next());
            }
            List<Integer> index = getIndex(line.get(0), delimiter, filter);
            if (!"stdout".equals(out)) {
                try (PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(argsName.get("out"))))) {
                    output.append(lineBuilder(index, line, delimiter));
                } catch (IOException e) {
                    e.getMessage();
                }
            } else {
                System.out.println(lineBuilder(index, line, delimiter));
            }
        }
    }

    public static String lineBuilder(List<Integer> index, List<String> line, String delimiter) {
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            String[] splitLine = line.get(i).split(delimiter);
            for (int k = 0; k < index.size(); k++) {
                rsl.append(splitLine[index.get(k)]).append(k != index.size() - 1 ? ";" : System.lineSeparator());
            }
        }
        return rsl.toString();
    }

    public static List<Integer> getIndex(String headString, String delimiter, String filter) {
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
        String delimiter = argsName.get("delimiter");
        if (!" ".equals(delimiter) && !",".equals(delimiter)
                && !";".equals(delimiter) && !"\t".equals(delimiter) && !"|".equals(delimiter)) {
            throw new IllegalArgumentException("Separator must be one character long");
        }
        if (!"stdout".equals(argsName.get("out")) && !argsName.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException("Target file must be in .csv format");
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Not Enough Input");
        }
        handle(ArgsName.of(args));
    }
}