package com.observation.observation.repository;

import com.observation.observation.entity.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ObservationRepository extends CrudRepository<Observation,Integer> {
    List<Observation> findByCelestialId (int id);
    List<Observation> findByUserId (int id);
    List<Observation> findByPublishedDate (LocalDate date);
}
