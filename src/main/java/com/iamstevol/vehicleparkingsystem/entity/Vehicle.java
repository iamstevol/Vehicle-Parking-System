package com.iamstevol.vehicleparkingsystem.entity;

import com.iamstevol.vehicleparkingsystem.constant.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Vehicle extends BaseEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vehicle_id", updatable = false, nullable = false)
    private String vehicleId;

    @Column(name = "vehicleType")
    private Category vehicleType;

    @Column(name = "numberPlate")
    private String numberPlate;

    @Column(name = "colour")
    private String colour;

    @ManyToMany(mappedBy = "vehicle")
    private List<ParkingSlot> slot = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private ParkingLot lot;
}
