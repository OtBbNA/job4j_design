package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseArgumentIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void checkValidateContainsEqualsSymbol() {
        NameLoad nameLoad = new NameLoad();
        String firstLine = "bottledwater";
        String secondLine = "processedcheese";
        assertThatThrownBy(() -> nameLoad.parse(firstLine, secondLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("contain the symbol")
                .hasMessageContaining(firstLine);
    }

    @Test
    void checkValidateStartWithEqualsSymbol() {
        NameLoad nameLoad = new NameLoad();
        String firstLine = "bottled=water";
        String secondLine = "=processed=cheese";
        assertThatThrownBy(() -> nameLoad.parse(firstLine, secondLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("contain a key")
                .doesNotHaveToString(firstLine)
                .hasMessageContaining(secondLine);
    }

    @Test
    void checkValidateLastSymbolIsNotEquals() {
        NameLoad nameLoad = new NameLoad();
        String firstLine = "bottled=water";
        String secondLine = "processedcheese=";
        assertThatThrownBy(() -> nameLoad.parse(firstLine, secondLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("contain a value")
                .doesNotHaveToString(firstLine)
                .hasMessageContaining(secondLine);
    }
}