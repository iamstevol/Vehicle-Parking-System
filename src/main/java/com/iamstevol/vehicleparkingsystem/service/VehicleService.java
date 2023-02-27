package com.iamstevol.vehicleparkingsystem.service;

import com.iamstevol.vehicleparkingsystem.dto.request.VehicleRequest;
import com.iamstevol.vehicleparkingsystem.dto.response.VehicleResponse;

import java.util.List;

public interface VehicleService {
    VehicleResponse addVehicle(VehicleRequest vehicleRequest);

    VehicleRequest getVehicle(String vehicleId);

    List<VehicleRequest> getAllVehicle();

    VehicleResponse deleteVehicle(String vehicleId);

    VehicleRequest searchVehicle(String numberPlate);
}
