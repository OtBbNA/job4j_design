package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The string must contain the symbol =");
    }

    @Test
    void whenOnlyTheKey() {
        String path = "./data/only_the_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Key or value is empty");
    }

    @Test
    void whenOnlyTheValue() {
        String path = "./data/only_the_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Key or value is empty");
    }

    @Test
    void whenOnlyTheSymbolEquals() {
        String path = "./data/only_the_symbol_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Key or value is empty");
    }


    @Test
    void whenWithoutSymbolEquals() {
        String path = "./data/without_symbol_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The string must contain the symbol =");
    }

    @Test
    void whenSeveralSymbolEquals() {
        String path = "./data/several_symbol_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password=Gen1");
    }
}