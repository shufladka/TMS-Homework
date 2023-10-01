package org.tms.patterns.abstract_factory.interfaces;

import org.tms.patterns.abstract_factory.AbstractProductA;
import org.tms.patterns.abstract_factory.AbstractProductB;
import org.tms.patterns.abstract_factory.interfaces.AbstractFactory;
import org.tms.patterns.abstract_factory.interfaces.ProductA;
import org.tms.patterns.abstract_factory.interfaces.ProductB;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new AbstractProductA();
    }

    @Override
    public ProductB createProductB() {
        return new AbstractProductB();
    }
}