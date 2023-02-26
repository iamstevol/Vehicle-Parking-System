package com.iamstevol.vehicleparkingsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "category_id", updatable = false, nullable = false)
    private String categoryId;

    @Column(name = "categoryName", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Vehicle> vehicle = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Ticket> ticket = new ArrayList<>();
}
