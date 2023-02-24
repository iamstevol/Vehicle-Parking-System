package com.iamstevol.vehicleparkingsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLot {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "lot_id", updatable = false, nullable = false)
    private String lotId;

    @OneToMany
    private List<ParkingSlot> slot = new ArrayList<>();

    @OneToMany(mappedBy = "lot")
    private List<Vehicle> vehicle;

    @OneToMany(mappedBy = "lot")
    private Set<Ticket> ticket = new HashSet<>();
}
