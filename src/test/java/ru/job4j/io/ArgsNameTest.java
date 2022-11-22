package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ArgsNameTest {
    @Test
    void whenGetFirst() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertThat(jvm.get("Xmx")).isEqualTo("512");
    }

    @Test
    void whenGetFirstReorder() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertThat(jvm.get("Xmx")).isEqualTo("512");
    }

    @Test
    void whenMultipleEqualsSymbol() {
        ArgsName jvm = ArgsName.of(new String[] {"-request=?msg=Exit="});
        assertThat(jvm.get("request")).isEqualTo("?msg=Exit=");
    }

    @Test
    void whenWrongSomeArgument() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Got an empty array");
    }

    @Test
    void whenMissingKey() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-=?msg=Exit="}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Key is empty");
    }

    @Test
    void whenMissingValue() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-Xmx=512", "-encoding="}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Value is empty");
    }

    @Test
    void whenMissingEqualsSymbol() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-encoding=UTF-8", "-Xmx512"}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("String does not match pattern: -key=value");
    }

    @Test
    void whenMissingMinusSymbol() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"request=?msg=Exit="}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("String does not match pattern: -key=value");
    }
}