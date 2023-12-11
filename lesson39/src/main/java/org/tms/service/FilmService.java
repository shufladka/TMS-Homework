package org.tms.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tms.domain.FilmEntity;
import org.tms.dto.FilmCreateDto;

import java.util.List;

public interface FilmService {

    List<FilmEntity> findAll();
    void save (FilmEntity film);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "dateOfIssue", source = "dateOfIssue")
    @Mapping(target = "rating", source = "rating")
    FilmEntity toEntity(FilmCreateDto filmDto);
}
