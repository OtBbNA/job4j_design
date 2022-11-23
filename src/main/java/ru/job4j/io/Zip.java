package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(path)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateDEO(String directory, String exclude, String output) {
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Directory is not correct");
        }
        if (!exclude.startsWith(".") && exclude.length() < 2) {
            throw new IllegalArgumentException("File extension is incorrect");
        }
        if (!output.contains(".zip") && output.length() < 5) {
            throw new IllegalArgumentException("Incorrect output filename");
        }
    }


    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName scissorsData = ArgsName.of(args);
        String directory = scissorsData.get("d");
        String exclude = scissorsData.get("e");
        String output = scissorsData.get("o");
        zip.validateDEO(directory, exclude, output);
        List<Path> searcher = Search.search(Path.of(directory), t -> !t.toFile().getName().endsWith(exclude));
        zip.packFiles(searcher, new File(output));
    }
}