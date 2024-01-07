package org.tms.mapper;

import org.mapstruct.Mapper;
import org.tms.dto.CarDto;
import org.tms.entity.CarEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarEntity toEntity(CarDto dto);

    CarDto toDto(CarEntity entity);

    List<CarDto> toDtoList(List<CarEntity> all);
}