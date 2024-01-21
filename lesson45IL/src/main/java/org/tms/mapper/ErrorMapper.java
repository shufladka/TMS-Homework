package org.tms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tms.exceptions.CarFailedException;
import org.tms.exceptions.IlError;

@Mapper(componentModel = "spring")
public interface ErrorMapper {

    @Mapping(target = "message", source = "message")
    @Mapping(target = "service", source = "service")
    @Mapping(target = "code", source = "code")
    IlError toIl(CarFailedException exc);
}