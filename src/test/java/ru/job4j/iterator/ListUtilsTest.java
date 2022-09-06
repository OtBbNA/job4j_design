package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3, 4, 4, 4, 8));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(7).containsSequence(1, 2, 3, 4, 4, 4, 8);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 6, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(7).containsSequence(1, 2, 3, 4, 4, 4, 8);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 6, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf4() {
        Predicate<Integer> filter = s -> s.equals(4);
        ListUtils.removeIf(input, filter);
        assertThat(input).hasSize(3).containsSequence(1, 3, 8);
    }

    @Test
    void whenReplaceIf2to4() {
        Predicate<Integer> filter = s -> s.equals(4);
        ListUtils.replaceIf(input, filter, 2);
        assertThat(input).hasSize(6).containsSequence(1, 3, 2, 2, 2, 8);
    }

    @Test
    void whenRemoveAll2() {
        List<Integer> removed = new ArrayList<>(Arrays.asList(1, 3, 8));
        ListUtils.removeAll(input, removed);
        assertThat(input).hasSize(3).containsSequence(4, 4, 4);
    }
}