package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void ifStatusHasNotChanged(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("unavailableSource.csv").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("300 10:58:01");
            out.println("200 10:59:01");
            out.println("300 11:01:02");
            out.println("300 11:02:02");
        }
        File target  = tempDir.resolve("unavailableResult.csv").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("").isEqualTo(rsl.toString());
    }

    @Test
    void ifOnePeriod(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("unavailableSource.csv").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("300 11:02:02");
        }
        File target  = tempDir.resolve("unavailableResult.csv").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;11:02:02;").isEqualTo(rsl.toString());
    }

    @Test
    void ifTwoPeriods(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("unavailableSource.csv").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("300 11:02:02");
            out.println("200 12:56:01");
            out.println("500 12:57:01");
            out.println("400 12:58:01");
            out.println("500 12:59:01");
            out.println("400 13:01:02");
            out.println("300 13:02:02");
        }
        File target  = tempDir.resolve("unavailableResult.csv").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;11:02:02;12:57:01;13:02:02;").isEqualTo(rsl.toString());
    }
}