package com.iamstevol.vehicleparkingsystem.entity;

import com.iamstevol.vehicleparkingsystem.constant.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Ticket extends BaseEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ticket_id", updatable = false, nullable = false)
    private String ticketId;

    @OneToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private ParkingSlot slot;

    @Column(name = "numberPlate")
    private String numberPlate;

    @CreationTimestamp
    @Column(name = "entryTime")
    private LocalDateTime entryTime;

    @CreationTimestamp
    @Column(name = "exitTime")
    private  LocalDateTime exitTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicleType")
    private Category vehicleType;

    @ManyToOne
    @JoinColumn(name = "lot_id", referencedColumnName = "lot_id")
    private ParkingLot lot;
}


