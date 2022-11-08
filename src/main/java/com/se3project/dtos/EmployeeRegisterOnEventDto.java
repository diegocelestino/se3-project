package com.se3project.dtos;

import com.se3project.enums.EmployeeRole;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Getter
public class EmployeeRegisterOnEventDto extends EmployeeRegisterDto {
    UUID collaboratorId;
    UUID eventId;
    EmployeeRole employeeRole;
    BigDecimal pay;

    @Override
    UUID getId() {
        return this.eventId;
    }
}
