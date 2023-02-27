package com.iamstevol.vehicleparkingsystem.controller;

import com.iamstevol.vehicleparkingsystem.dto.request.VehicleRequest;
import com.iamstevol.vehicleparkingsystem.dto.response.VehicleResponse;
import com.iamstevol.vehicleparkingsystem.service.VehicleService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
@Log4j2
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        log.info("Inside addVehicle of VehicleController");
        VehicleResponse response = vehicleService.addVehicle(vehicleRequest);
        log.info("Vehicle has been added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable("id") String vehicleId) {
        log.info("Inside getVehicle of VehicleController");
        VehicleRequest response = vehicleService.getVehicle(vehicleId);
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllVehicle() {
        log.info("Inside getVehicle of VehicleController");
        List<VehicleRequest> response = vehicleService.getAllVehicle();
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") String vehicleId) {
        log.info("Inside getVehicle of VehicleController");
        VehicleResponse response = vehicleService.deleteVehicle(vehicleId);
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{numberPlate}")
    public ResponseEntity<?> searchVehicle(@PathVariable("numberPlate") String numberPlate) {
        log.info("Inside getVehicle of VehicleController");
        VehicleRequest response = vehicleService.searchVehicle(numberPlate);
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
