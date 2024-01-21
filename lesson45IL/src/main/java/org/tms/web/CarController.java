package org.tms.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.tms.dto.CarDto;
import org.tms.exceptions.IlError;
import org.tms.service.StoreService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")

@OpenAPIDefinition(info = @Info(
        title = "This is a controller for processing car search requests",
        description = "The controller allows you to save and search for cars (all or by ID)",
        version = "0.0.1"
))
public class CarController {

    private final StoreService service;

    @PostMapping
    public CarDto save(@Valid @RequestBody CarDto dto) {
        return service.save(dto);
    }


    @GetMapping("/{id}")
    @Operation(tags = "search",
            description = "Method to search car by identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car search successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = CarDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "unknown identifier",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema (
                                            implementation = IlError.class
                                    )
                            )
                    )
            })
    public CarDto find(@PathVariable(name = "id") Integer id) {
        return service.find(id);
    }

    @GetMapping
    public List<CarDto> findAll() {
        return service.findAll();
    }
}