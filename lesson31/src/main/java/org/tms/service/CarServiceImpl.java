package org.tms.service;

import org.springframework.stereotype.Service;
import org.tms.domain.Car;
import org.tms.exception.AgeException;
import org.tms.exception.ConditionException;
import org.tms.exception.ModelException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    List<Car> carList = new ArrayList<>();

    @Override
    public List<Car> getCar() {
        return carList;
    }

    @Override
    public void save(Car car) {

        if (car.getModel() == null || car.getModel().isBlank()) {
            throw new ModelException(car);
        }

        if (car.getCondition() == null || car.getCondition().isBlank()) {
            throw new ConditionException(car);
        }

        if (car.getAge() == null || car.getAge() < 0) {
            throw new AgeException(car);
        }

        carList.add(car);
        System.out.println("save car");
    }
}