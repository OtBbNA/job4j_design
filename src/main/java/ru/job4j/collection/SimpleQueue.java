package ru.job4j.collection;

import java.util.*;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (in.isEmpty() || out.isEmpty()) {
            throw new NoSuchElementException();
        }
        while (in.getSize() > 1) {
            out.push(in.pop());
        }
        T rsl = in.pop();
        while (out.getSize() >= 1) {
            in.push(out.pop());
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }
}