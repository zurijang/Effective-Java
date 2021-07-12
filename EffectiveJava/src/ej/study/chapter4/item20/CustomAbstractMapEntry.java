package ej.study.chapter4.item20;

import java.util.Map;

public abstract class CustomAbstractMapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public CustomAbstractMapEntry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    abstract void printKey();

    abstract void printValue();

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return this.value=value;
    }
}
