package com.observation.observation.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int celestialId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate publishedDate;

    String description;

    Boolean isPublic;

    public Observation(int userId, int celestialId, LocalDate publishedDate, String description, Boolean isPublic) {
        this.userId = userId;
        this.celestialId = celestialId;
        this.publishedDate = publishedDate;
        this.description = description;
        this.isPublic = isPublic;
    }
}
