package com.iamstevol.vehicleparkingsystem.entity;

import com.iamstevol.vehicleparkingsystem.constant.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSlot {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "slot_id", updatable = false, nullable = false)
    private String slotId;

    @Column(name = "status")
    private Status status;

    @OneToOne(mappedBy = "slot")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "lot_id", referencedColumnName = "lot_id")
    private ParkingLot lot;

    @ManyToMany
    @JoinTable(name = "vehicle_slot",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "slot_id"))
    private List<Vehicle> vehicle = new ArrayList<>();
}
