package org.tms.service;

import org.tms.domain.FilmEntity;
import org.tms.dto.FilmSearchDto;

import javax.transaction.Transactional;
import java.util.List;

public interface FilmService {

    List<FilmEntity> findAll();

    void save (FilmEntity film);

    @Transactional
    void updateRating(Integer id, Integer rating);

    List<FilmEntity> findByCriteria(FilmSearchDto searchDto);
}