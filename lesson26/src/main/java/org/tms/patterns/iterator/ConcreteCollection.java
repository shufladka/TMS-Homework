package org.tms.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCollection <T> {
    private List<T> list = new ArrayList<>();

    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(list);
    }

    public void addToList(T book) {
        list.add(book);
    }
}