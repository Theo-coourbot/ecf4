package com.example.celestialobject.service;

import com.example.celestialobject.entity.CelestialObjectApp;
import com.example.celestialobject.repository.CelestialObjectAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelestialObjectAppService {
@Autowired
    CelestialObjectAppRepository _celestialObjectAppRepository;


    public CelestialObjectApp createCelstiaObj(String type, String name) {
        CelestialObjectApp celestialObjectApp = CelestialObjectApp.builder().type(type).name(name).build();
        _celestialObjectAppRepository.save(celestialObjectApp);
        return celestialObjectApp;
    }

    public CelestialObjectApp findByCelestialObjId(int id) {
        Optional<CelestialObjectApp> celestialObjectApp = _celestialObjectAppRepository.findById(id);
        if(celestialObjectApp.isEmpty()) {
        throw new RuntimeException("objet celeste Not found");
        }
            return celestialObjectApp.get();
    }
//    public List<CelestialObjectApp> findByCelestialObjByType(String type) {
//        List<CelestialObjectApp> celestialObjectAppList = _celestialObjectAppRepository.findByType(type);
//        if(celestialObjectAppList.size()>0) {
//            return celestialObjectAppList;
//        }
//        throw new RuntimeException("type d'objet celeste Not found");
//    }



}
