package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader app = new BufferedReader(new FileReader(path))) {
            for (String rsl = app.readLine(); rsl != null; rsl = app.readLine()) {
                if (!rsl.isBlank() && !rsl.startsWith("#")) {
                    if (!rsl.contains("=")) {
                        throw new IllegalArgumentException("The string must contain the symbol =");
                    }
                    String[] mapKV = rsl.split("=", 2);
                    if (mapKV[0].isEmpty() || mapKV[1].isEmpty()) {
                        throw new IllegalArgumentException("Key or value is empty");
                    }
                    values.put(mapKV[0], mapKV[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}