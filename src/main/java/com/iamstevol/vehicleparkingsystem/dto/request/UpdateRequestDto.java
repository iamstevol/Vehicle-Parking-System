package com.iamstevol.vehicleparkingsystem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRequestDto {

    private String categoryName;
}
