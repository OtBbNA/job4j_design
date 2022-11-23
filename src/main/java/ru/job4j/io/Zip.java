package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(path)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(path)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName scissorsData = ArgsName.of(args);
        List<Path> searcher = Search.search(Path.of(scissorsData.get("d")), t -> !t.toFile().getName().startsWith(scissorsData.get("e"))).stream().collect(Collectors.toList());
        zip.packFiles(searcher, new File(scissorsData.get("o")));
    }
}