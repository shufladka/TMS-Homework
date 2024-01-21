package org.tms.service;

import org.tms.lesson43il.dto.CarDto;

import java.util.List;

public interface StoreService {
    CarDto save (CarDto dto);
    CarDto find (Integer id);
    List<CarDto> findAll();
}