package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void increaseSize(int s) {
        if (s == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        } else if (0 == container.length) {
            container = Arrays.copyOf(container, 10);
        }
    }

    @Override
    public void add(T value) {
        modCount++;
        increaseSize(size);
        container[size++] = value;
    }

   @Override
    public T set(int index, T newValue) {
        T setData = get(index);
        container[index] = newValue;
        return setData;
    }

   @Override
    public T remove(int index) {
        T removedData = get(index);
        modCount++;
        size--;
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size] = null;
        return removedData;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

   @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
        private int index = 0;
        private int modCountChecker = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != modCountChecker) {
                        throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}