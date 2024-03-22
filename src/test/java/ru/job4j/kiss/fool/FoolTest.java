package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void AllAnswerBefore10() {
        List<String> expected = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz");
        for (int i = 0; i < 10; i++) {
            assertThat(Fool.answer(i + 1)).isEqualTo(expected.get(i));
        }
    }

    @Test
    void AllAnswerBefore100() {
        List<String> expected = List.of("91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz");
        for (int i = 0; i < 10; i++) {
            assertThat(Fool.answer(i + 91)).isEqualTo(expected.get(i));
        }
    }
}