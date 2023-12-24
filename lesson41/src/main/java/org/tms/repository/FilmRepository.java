package org.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.tms.domain.FilmEntity;
import java.util.Optional;

@Component
public interface FilmRepository extends JpaRepository<FilmEntity, Integer>, JpaSpecificationExecutor<FilmEntity> {
    @Modifying
    Optional<FilmEntity> updateRating(Integer id, Integer rating);
}