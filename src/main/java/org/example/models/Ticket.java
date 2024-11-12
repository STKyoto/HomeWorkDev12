package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id", nullable = true)
    private Planet fromPlanet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id", nullable = true)
    private Planet toPlanet;
}
