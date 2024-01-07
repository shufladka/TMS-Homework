package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.tms.dto.CarDto;
import org.tms.service.CarService;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService service;

    @PostMapping
    public CarDto save(@RequestBody CarDto request) {
        return service.save(request);
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