package org.tms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tms.lesson43il.dto.CarDto;

import java.util.List;

@FeignClient (name = "${app.clients.cars.name}", url = "${app.clients.cars.url}", path = "${app.clients.cars.path}")
public interface CarClient {

    @PostMapping
    CarDto save(@RequestBody CarDto dto);

    @GetMapping("/{id}")
    CarDto find(@PathVariable(name = "id") Integer id);

    @GetMapping
    List<CarDto> findAll();
}