package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E>  implements LinkedList<E> {

    private int modCount;
    private int size;
    transient Node<E> first;
    transient Node<E> last;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> f = first;
        for (int i = 0; i < index; i++) {
            f = f.next;
        }
        return f.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private int modCountChecker = modCount;
            private Node<E> presValue = first;

            @Override
            public boolean hasNext() {
                if (modCount != modCountChecker) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                Node<E> buffer = presValue;
                presValue = presValue.next;
                return buffer.item;
            }
        };
    }
}
