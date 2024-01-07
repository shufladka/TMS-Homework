package org.tms.service;

import org.tms.dto.CarDto;
import java.util.List;

public interface StoreService {
    CarDto save (CarDto dto);
    CarDto find (Integer id);
    List<CarDto> findAll();
}