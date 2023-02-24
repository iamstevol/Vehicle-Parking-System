package com.iamstevol.vehicleparkingsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    MOTORCYCLE("small"),

    CAR("medium"),

    TRUCK("large"),

    BUS("extra_large");

    private final String size;

}
