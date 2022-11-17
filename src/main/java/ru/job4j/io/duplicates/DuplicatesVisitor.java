package ru.job4j.io.duplicates;

import ru.job4j.collection.LinkedList;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, Set<Path>> rsl = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty i = new FileProperty(Files.size(file), file.getFileName().toString());
        rsl.putIfAbsent(i, new HashSet<>());
        if (rsl.containsKey(i)) {
            rsl.get(i).add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public Map<FileProperty, Set<Path>> getRsl() {
        return rsl;
    }
}