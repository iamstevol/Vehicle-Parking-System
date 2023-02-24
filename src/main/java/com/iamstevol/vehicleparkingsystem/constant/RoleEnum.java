package com.iamstevol.vehicleparkingsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    USER("ROLE_USER"),

    ADMIN("ROLE_ADMIN");

    private final String role;
}
