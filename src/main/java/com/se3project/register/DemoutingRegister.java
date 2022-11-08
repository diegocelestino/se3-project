package com.se3project.register;

import com.se3project.model.Demouting;
import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.repository.DemoutingRepository;

public class DemoutingRegister extends EmployeeRegister {
    private final DemoutingRepository demoutingRepository;

    public DemoutingRegister(DemoutingRepository demoutingRepository, EmployeeRegister next) {
        super(null);
        this.demoutingRepository = demoutingRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Event event) {
        Demouting demouting = (Demouting) employee;
        demouting.setEvent(event);
        return demoutingRepository.save(demouting);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Demouting;
    }
}
