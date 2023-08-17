package com.observation.observation.controller;

import com.observation.observation.entity.Observation;
import com.observation.observation.service.ObservationService;
import com.observation.observation.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("observation")
public class ObservationController {

    @Autowired
    private ObservationService _observationService;

    @PostMapping("")
    public ResponseEntity<Observation> postObservation (@RequestParam int userId, @RequestParam int celestialId, @RequestParam LocalDate publishedDate, @RequestParam String description, @RequestParam Boolean isPublic,@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Observation observation = _observationService.createObservation(userId,celestialId,description,isPublic,publishedDate);
        return ResponseEntity.ok(observation);
    }

    @GetMapping("user/{userid}")
    public ResponseEntity<List<Observation>> getByUser(@PathVariable int userid, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(_observationService.getByUserId(userid));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("celestial/{celestialId}")
    public ResponseEntity<List<Observation>> getBycelestialId(@PathVariable int celestialId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(_observationService.getByCelestialId(celestialId));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("date/{date}")
    public ResponseEntity<List<Observation>> getByDate(@PathVariable LocalDate date, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(_observationService.getByDate(date));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }




}
