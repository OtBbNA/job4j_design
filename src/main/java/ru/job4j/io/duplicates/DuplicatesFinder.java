package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor i = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), i);
        Map<FileProperty, Set<Path>> r = i.getRsl();
        for (FileProperty s : r.keySet()) {
            if (r.get(s).size() > 1) {
                System.out.print(String.format("%s - %s%n", s.getName(), s.getSize()));
                for (Path e : r.get(s)) {
                    System.out.println(e);
                }
            }
        }
    }
}