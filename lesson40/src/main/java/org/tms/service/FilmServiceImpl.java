package org.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.domain.FilmEntity;

import java.util.List;

@RequiredArgsConstructor

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository repository;

    @Override
    public List<FilmEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(FilmEntity film) {
        repository.save(film);
    }

    @Override
    public void updateRating(Integer id, Integer rating) {
        repository.updateRating(id, rating);
    }
}