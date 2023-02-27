package com.iamstevol.vehicleparkingsystem.controller;

import com.iamstevol.vehicleparkingsystem.dto.response.UserResponse;
import com.iamstevol.vehicleparkingsystem.dto.response.VehicleResponse;
import com.iamstevol.vehicleparkingsystem.security.auth.AuthenticationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Log4j2
public class UserController {
    private final AuthenticationService authenticationService;
    @Autowired
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        log.info("Inside getAllUsers of UserController");
        List<UserResponse> response = authenticationService.getAllUser();
        log.info("Successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
