package org.tms.service;

import org.tms.domain.Car;
import java.util.List;

public interface CarService {
    List<Car> getCar();
    void save(Car Car);
}