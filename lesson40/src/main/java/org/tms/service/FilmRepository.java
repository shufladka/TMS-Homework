package org.tms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.tms.domain.FilmEntity;

import javax.transaction.Transactional;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
        @Modifying
        @Transactional
    void updateRating(Integer id, Integer rating);
}