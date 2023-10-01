package org.tms.patterns.iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class ConcreteIterator <T> implements Iterator <T> {

    private int iteration = 0;
    private List<T> list;

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public T getNext() {
        if (hasMore()) {
            T result = list.get(iteration);
            iteration++;

            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasMore() {
        return iteration < list.size();
    }
}