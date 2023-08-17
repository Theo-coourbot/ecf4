package com.example.celestialobject.controller;

import com.example.celestialobject.entity.CelestialObjectApp;
import com.example.celestialobject.service.CelestialObjectAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/celestialObj")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class CelestialObjectController {
    @Autowired
    private  CelestialObjectAppService _celestialObjectAppService;



    @PostMapping("")
    public ResponseEntity<CelestialObjectApp> post(@RequestParam String type, @RequestParam String name) {
        CelestialObjectApp celestialObjectApp = _celestialObjectAppService.createCelstiaObj(type, name);
        return ResponseEntity.ok(celestialObjectApp);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CelestialObjectApp> get(@PathVariable int id) {
        CelestialObjectApp celestialObjectApp = _celestialObjectAppService.findByCelestialObjId(id);
        return ResponseEntity.ok(celestialObjectApp);
    }
//    @GetMapping("/type/{type}")
//    public ResponseEntity<List<CelestialObjectApp>> getAllByType(@PathVariable String type) {
//        List<CelestialObjectApp> celestialObjectAppList = _celestialObjectAppService.findByCelestialObjByType(type);
//        return ResponseEntity.ok(celestialObjectAppList);
//    }

}
