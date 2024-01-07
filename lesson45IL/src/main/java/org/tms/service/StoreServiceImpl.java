package org.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.client.CarClient;
import org.tms.dto.CarDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final CarClient client;

    @Override
    public CarDto save(CarDto dto) {
        return client.save(dto);
    }

    @Override
    public CarDto find(Integer id) {
        return client.find(id);
    }

    @Override
    public List<CarDto> findAll() {
        return client.findAll();
    }
}