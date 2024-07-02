package com.middleware.demo.dto;

import com.middleware.demo.model.Court;
import com.middleware.demo.model.Officer;
import com.middleware.demo.model.Violation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationDto {

   private Officer officer;

   private Court court;

   private Violation violation;
}
