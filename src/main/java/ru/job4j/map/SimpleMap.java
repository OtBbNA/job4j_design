package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count > capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    private int indexFor(int hash) {
        return hash % (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] buffer = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> bufvalue : buffer) {
            if (bufvalue != null) {
                put(bufvalue.key, bufvalue.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key));
        return table[index] != null && (hash(table[index].key)
                == hash(key) && (Objects.equals(key, table[index].key)))
                ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        modCount++;
        int index = indexFor(hash(key));
        if (table[index] != null && (hash(table[index].key)
                == hash(key) && (Objects.equals(key, table[index].key)))) {
            table[index] = null;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int mod = modCount;
            int index = 0;
            @Override
            public boolean hasNext() {
                if (mod != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}