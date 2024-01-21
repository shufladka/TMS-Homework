package org.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.tms.lesson43bl.entity.CarEntity;

@Component
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}