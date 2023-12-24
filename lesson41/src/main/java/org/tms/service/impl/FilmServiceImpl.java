package org.tms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.tms.domain.FilmEntity;
import org.tms.domain.Genre;
import org.tms.dto.FilmSearchDto;
import org.tms.repository.FilmRepository;
import org.tms.service.FilmService;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<FilmEntity> findByCriteria(FilmSearchDto dto) {
        return repository.findAll(createSpecif(dto));
    }

    private Specification<FilmEntity>  createSpecif(FilmSearchDto searchDto){
        return (root, query, builder) -> {
            String name = searchDto.getName();
            Genre genre = searchDto.getGenre();
            Date date = searchDto.getDateOfIssue();
            Integer from = searchDto.getFrom();
            Integer to = searchDto.getTo();

            var predicates = new ArrayList<Predicate>();

            if (name != null && !name.isBlank()){
                Predicate nameEq = builder.equal(root.get("name"), name);
                predicates.add(nameEq);
            }
            if (genre != null){
                Predicate genreEq = builder.equal(root.get("genre"), genre);
                predicates.add(genreEq);
            }
            if (date != null){
                Predicate dateEq = builder.equal(root.get("date"), date);
                predicates.add(dateEq);
            }
            if (from != null){
                Predicate ratingGe = builder.ge(root.get("rating"), from);
                predicates.add(ratingGe);
            }
            if (to != null){
                Predicate ratingLe = builder.le(root.get("rating"), to);
                predicates.add(ratingLe);
            }

            Predicate[] array = predicates.toArray(Predicate[]::new);
            return builder.and(array);
        };
    }
}