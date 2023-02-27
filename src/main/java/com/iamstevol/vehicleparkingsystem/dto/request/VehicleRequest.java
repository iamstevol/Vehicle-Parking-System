package com.iamstevol.vehicleparkingsystem.dto.request;

import com.iamstevol.vehicleparkingsystem.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRequest {
    private String category;
    private String numberPlate;
    private String colour;
    private String ownerName;
}
