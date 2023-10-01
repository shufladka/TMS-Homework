package org.tms.patterns.abstract_factory;

import org.tms.patterns.abstract_factory.interfaces.ProductB;

public class AbstractProductB implements ProductB {

    @Override
    public void actionB() {
        System.out.println("AbstractProductB in action.");
    }
}