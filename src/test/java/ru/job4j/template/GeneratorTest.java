package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {

    @Test
    void whenMapIsNull() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}?";
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenTemplateIsNull() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", "Arthur");
        exampleMap.put("subject", "you");
        assertThatThrownBy(() -> templateGenerator.produce(null, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapIsEmpty() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}?";
        Map<String, String> exampleMap = new HashMap<>();
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenTemplateDoNotContainsKey() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a Artur, Who are you?";
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", "Arthur");
        exampleMap.put("subject", "you");
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenValueInMapIsNull() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}?";
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", null);
        exampleMap.put("subject", "you");
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapHasMoreKeys() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}?";
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", "Arthur");
        exampleMap.put("subject", "you");
        exampleMap.put("dogName", "Gav");
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapHasNotSomeKeys() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}? Is your dog's name ${dogName}?";
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", "Arthur");
        exampleMap.put("subject", "you");
        assertThatThrownBy(() -> templateGenerator.produce(exampleString, exampleMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNoProblem() {
        String expected = "I am a Arthur, Who are you?";
        TemplateGenerator templateGenerator = new TemplateGenerator();
        String exampleString = "I am a ${name}, Who are ${subject}?";
        Map<String, String> exampleMap = new HashMap<>();
        exampleMap.put("name", "Arthur");
        exampleMap.put("subject", "you");
        assertThat(expected).isEqualTo(templateGenerator.produce(exampleString, exampleMap));
    }
}