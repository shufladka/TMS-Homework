package org.tms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tms.domain.FilmEntity;
import org.tms.dto.FilmCreateDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "dateOfIssue", source = "dateOfIssue")
    @Mapping(target = "rating", source = "rating")
    FilmEntity toEntity(FilmCreateDto filmDto);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "dateOfIssue", source = "dateOfIssue")
    @Mapping(target = "rating", source = "rating")
    FilmCreateDto toDto(FilmEntity filmEntity);

    List<FilmCreateDto> toDto (List<FilmEntity> entityList);
}