package com.example.celestialobject.repository;

import com.example.celestialobject.entity.CelestialObjectApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelestialObjectAppRepository extends CrudRepository<CelestialObjectApp,Integer> {
    public List<CelestialObjectApp> findByType (String type);
}
