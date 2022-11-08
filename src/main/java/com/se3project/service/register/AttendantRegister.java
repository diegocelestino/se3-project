package com.se3project.service.register;

import com.se3project.model.*;
import com.se3project.repository.AttendantRepository;

public class AttendantRegister extends EmployeeRegister {
    private final AttendantRepository attendantRepository;

    public AttendantRegister(AttendantRepository attendantRepository, EmployeeRegister next) {
        super(next);
        this.attendantRepository = attendantRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Registrable bar) {
        Attendant attendant = (Attendant) employee;
        attendant.setBar((Bar) bar);
        return attendantRepository.save(attendant);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Attendant;
    }
}
