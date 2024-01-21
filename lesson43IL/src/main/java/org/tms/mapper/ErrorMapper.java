package org.tms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tms.lesson43il.exceptions.CarFailedException;
import org.tms.lesson43il.exceptions.ErrorDetailsException;

@Mapper(componentModel = "spring")
public interface ErrorMapper {

    @Mapping(target = "message", source = "message")
    @Mapping(target = "service", source = "service")
    @Mapping(target = "code", source = "code")
    ErrorDetailsException toIl(CarFailedException exc);
}