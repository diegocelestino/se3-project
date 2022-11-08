package com.se3project.dtos;

import com.se3project.enums.EmployeeRole;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class EmployeeRegisterDto {
    public abstract UUID getCollaboratorId();
    public abstract EmployeeRole getEmployeeRole();
    public abstract BigDecimal getPay();
    abstract UUID getId();
}
