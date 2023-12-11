package org.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.domain.FilmEntity;
import org.tms.dto.FilmCreateDto;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {

    private final Repository repository;

    @Override
    public List<FilmEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(FilmEntity film) {
        repository.save(film);
    }

    @Override
    public FilmEntity toEntity(FilmCreateDto filmDto) {
        return new FilmEntity(UUID.randomUUID(), filmDto.getName(), filmDto.getGenre(), filmDto.getDateOfIssue(), filmDto.getRating());
    }
}