package org.tms.service;

import org.tms.domain.FilmEntity;

import java.util.List;

public interface FilmService {

    List<FilmEntity> findAll();

    void save (FilmEntity film);

    void updateRating(Integer id, Integer rating);
}