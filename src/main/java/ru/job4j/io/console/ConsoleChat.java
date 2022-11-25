package ru.job4j.io.console;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = readPhrases();
        List<String> diaLog = new ArrayList<>();
        if (answers.isEmpty()) {
            throw new NullPointerException("Make sure the answer file is not empty");
        }
        String switcher = CONTINUE;
        while (!switcher.equals(OUT)) {
            Scanner in = new Scanner(System.in);
            String i = in.nextLine();
            diaLog.add(i);
            if (STOP.equals(i)) {
                switcher = STOP;
            }
            if (CONTINUE.equals(i)) {
                switcher = CONTINUE;
            }
            if (OUT.equals(i)) {
                switcher = OUT;
            }
            if (switcher.equals(CONTINUE)) {
                String ans = answers.get(new Random().nextInt(answers.size()));
                diaLog.add(ans);
                System.out.println(ans);
            }
        }
        saveLog(diaLog);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(botAnswers))) {
            return in.lines().collect(Collectors.toCollection(() -> rsl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(path)))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("DiaLog.txt", "./data/Answers.txt");
        cc.run();
    }
}