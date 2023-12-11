package org.tms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tms.domain.FilmEntity;

public interface Repository extends JpaRepository<FilmEntity, Integer> {
}