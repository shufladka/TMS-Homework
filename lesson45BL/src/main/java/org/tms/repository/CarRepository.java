package org.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tms.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}