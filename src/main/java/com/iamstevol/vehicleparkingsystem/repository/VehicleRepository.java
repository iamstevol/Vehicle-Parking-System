package com.iamstevol.vehicleparkingsystem.repository;

import com.iamstevol.vehicleparkingsystem.entity.Category;
import com.iamstevol.vehicleparkingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle findVehicleByNumberPlate(String numberPlate);
}
