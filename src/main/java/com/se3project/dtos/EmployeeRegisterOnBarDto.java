package com.se3project.dtos;

import com.se3project.enums.EmployeeRole;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Getter
public class EmployeeRegisterOnBarDto {
    UUID collaboratorId;
    EmployeeRole employeeRole;
    BigDecimal pay;
    UUID barId;
}
