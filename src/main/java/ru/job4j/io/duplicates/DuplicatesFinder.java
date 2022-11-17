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
        for (FileProperty filePrKey : r.keySet()) {
            if (r.get(filePrKey).size() > 1) {
                System.out.print(String.format("%s - %s%n", filePrKey.getName(), filePrKey.getSize()));
                for (Path valueSet : r.get(filePrKey)) {
                    System.out.println(valueSet);
                }
            }
        }
    }
}