package com.swiss.trails.swisstrails_api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter  @Setter 
@NoArgsConstructor @AllArgsConstructor 
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double lengthKm;
    private int elevation;
    private String difficulty;

    @OneToMany(mappedBy = "trail", cascade = CascadeType.ALL)
    private List<Checkpoint> checkpoints = new ArrayList<>();
}
