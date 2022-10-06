package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddCopyInTheEnd() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(3)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAdd1ThenContains1() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(4)).isTrue();
        assertThat(set.add(9)).isTrue();
        assertThat(set.contains(1)).isTrue();
    }

    @Test
    void whenAddNotContains() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(4)).isTrue();
        assertThat(set.add(9)).isTrue();
        assertThat(set.contains(3)).isFalse();
    }

    @Test
    void whenAddNullInTheEnd() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(4)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenCheckIterator() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> iterator = set.iterator();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(3)).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(Integer.valueOf(1)).isEqualTo(iterator.next());
        assertThat(iterator.hasNext()).isTrue();
        assertThat(Integer.valueOf(2)).isEqualTo(iterator.next());
        assertThat(iterator.hasNext()).isTrue();
        assertThat(Integer.valueOf(3)).isEqualTo(iterator.next());
        assertThat(iterator.hasNext()).isFalse();
    }
}