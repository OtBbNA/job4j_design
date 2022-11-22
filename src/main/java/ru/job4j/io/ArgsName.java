package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void validateCommand(String command) {
        if (!command.contains("-") || !command.contains("=")) {
            throw new IllegalArgumentException("String does not match pattern: -key=value");
        }
    }

    private void validateKey(String key) {
        if (!key.startsWith("-") || key.length() <= 1) {
            throw new IllegalArgumentException("Key is empty");
        }
    }

    private void validateValue(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Value is empty");
        }
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Got an empty array");
        }
        String[] buf = new String[2];
        for (int i = 0; i < args.length; i++) {
            validateCommand(args[i]);
            buf = args[i].split("=", 2);
            validateKey(buf[0]);
            validateValue(buf[1]);
            values.put(String.valueOf(new StringBuilder(buf[0]).deleteCharAt(0)), buf[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}