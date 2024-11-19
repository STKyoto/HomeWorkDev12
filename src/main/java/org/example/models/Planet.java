package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> fromPlanet;
    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> toPlanet;
}
