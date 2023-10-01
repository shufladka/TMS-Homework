package org.tms.patterns.iterator;

public interface Iterator <T> {
    T getNext();
    boolean hasMore();
}