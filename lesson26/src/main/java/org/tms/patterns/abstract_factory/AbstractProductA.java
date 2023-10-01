package org.tms.patterns.abstract_factory;

import org.tms.patterns.abstract_factory.interfaces.ProductA;

public class AbstractProductA implements ProductA {

    @Override
    public void actionA() {
        System.out.println("AbstractProductA in action.");
    }
}