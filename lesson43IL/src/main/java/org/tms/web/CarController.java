package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.tms.lesson43il.dto.CarDto;
import org.tms.lesson43il.service.StoreService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")
public class CarController {

    private final StoreService service;

    @PostMapping
    public CarDto save(@RequestBody CarDto dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public CarDto find(@PathVariable(name = "id") Integer id) {
        return service.find(id);
    }

    @GetMapping
    public List<CarDto> findAll() {
        return service.findAll();
    }
}