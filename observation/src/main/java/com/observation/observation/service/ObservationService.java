package com.observation.observation.service;

import com.observation.observation.entity.Observation;
import com.observation.observation.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository _observationRepository;

    public Observation createObservation(int userId, int celestialId, String description, boolean isPublic, LocalDate publishedDate){
        Observation observation = Observation.builder().userId(userId).celestialId(celestialId).description(description).isPublic(isPublic).publishedDate(publishedDate).build();
        _observationRepository.save(observation);
        return observation;
    }

    public List<Observation> getByUserId (int id){
        List<Observation> observationList = _observationRepository.findByUserId(id);
        List<Observation> sortedObservationList = new ArrayList<>();
        for (Observation o : observationList){
            if (o.getIsPublic()){
                sortedObservationList.add(o);
            }
        }
        return sortedObservationList;
    }
    public List<Observation> getByCelestialId (int id){
        List<Observation> observationList = _observationRepository.findByCelestialId(id);
        List<Observation> sortedObservationList = new ArrayList<>();
        for (Observation o : observationList){
            if (o.getIsPublic()){
                sortedObservationList.add(o);
            }
        }
        return sortedObservationList;
    }
    public List<Observation> getByDate (LocalDate date){
        List<Observation> observationList = _observationRepository.findByPublishedDate(date);
        List<Observation> sortedObservationList = new ArrayList<>();
        for (Observation o : observationList){
            if (o.getIsPublic()){
                sortedObservationList.add(o);
            }
        }
        return sortedObservationList;
    }


}
