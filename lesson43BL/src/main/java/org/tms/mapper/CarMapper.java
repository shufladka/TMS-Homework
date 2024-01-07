package org.tms.mapper;

import org.mapstruct.Mapper;
import org.tms.lesson43bl.dto.CarDto;
import org.tms.lesson43bl.entity.CarEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarEntity toEntity(CarDto dto);

    CarDto toDto(CarEntity entity);

    List<CarDto> toDtoList(List<CarEntity> all);
}