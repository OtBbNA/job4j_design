package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import ru.job4j.collection.SimpleQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean rsl = !contains(value);
        if (rsl) {
            set.add(value);
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
            for (T t : set) {
                if (Objects.equals(value, t)) {
                    rsl = true;
                    break;
                }
            }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < set.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return set.get(index++);
            }
        };
    }
}