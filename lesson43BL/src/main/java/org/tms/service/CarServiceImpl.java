package org.tms.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.lesson43bl.dto.CarDto;
import org.tms.lesson43bl.entity.CarEntity;
import org.tms.lesson43bl.exceptions.CarFailedException;
import org.tms.lesson43bl.mapper.CarMapper;
import org.tms.lesson43bl.repository.CarRepository;

import java.util.List;

@RequiredArgsConstructor

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarMapper mapper;
    private final CarRepository repository;

    @Override
    public CarDto save(CarDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                ));
    }

    @Override
    public CarDto find(Integer id) {

        CarEntity car = repository.findById(id)
                .orElseThrow(() -> new CarFailedException("The car was not found. Please, try another ID."));

        return mapper.toDto(car);
    }

    @Override
    public List<CarDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }
}