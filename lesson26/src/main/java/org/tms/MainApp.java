/*
Паттерны abstract factory, observer, iterator
*/

package org.tms;

import org.tms.patterns.abstract_factory.interfaces.ConcreteFactory;
import org.tms.patterns.abstract_factory.interfaces.AbstractFactory;
import org.tms.patterns.abstract_factory.interfaces.ProductA;
import org.tms.patterns.abstract_factory.interfaces.ProductB;
import org.tms.patterns.iterator.ConcreteCollection;
import org.tms.patterns.iterator.Iterator;
import org.tms.patterns.observer.service.AccountantService;
import org.tms.patterns.observer.Employee;
import org.tms.patterns.observer.service.HrService;
import org.tms.patterns.observer.service.SecurityService;

public class MainApp {
    public static void main(String[] args) {

        // Применение паттерна Abstract Factory
        AbstractFactory abstractFactory = new ConcreteFactory();
        ProductA productA = abstractFactory.createProductA();
        ProductB productB = abstractFactory.createProductB();

        productA.actionA();
        productB.actionB();

        System.out.println(" ");


        // Применение паттерна Iterator
        ConcreteCollection<String> concreteCollection = new ConcreteCollection<>();
        concreteCollection.addToList("The first book");
        concreteCollection.addToList("The second book");
        concreteCollection.addToList("The third book");

        Iterator<String> iterator = concreteCollection.createIterator();
        while (iterator.hasMore()) {
            System.out.println(iterator.getNext() + " has been added to the library");
        }

        System.out.println(" ");


        // Применение паттерна Observer
        Employee employee = new Employee("Pavel", "Pavlov", "engineer");
        AccountantService accountantService = new AccountantService();
        SecurityService securityService = new SecurityService();
        HrService hrService = new HrService();

        employee.addObserver(accountantService);
        employee.addObserver(securityService);
        employee.addObserver(hrService);

        employee.create();
        System.out.println("------------------------------------");
        employee.changePosition("senior engineer");
        System.out.println("------------------------------------");
        employee.delete();
    }
}