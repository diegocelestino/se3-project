package com.se3project.register;

import com.se3project.model.Coordinator;
import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.repository.CoordinatorRepository;

public class CoordinatorRegister extends EmployeeRegister {
    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorRegister(CoordinatorRepository coordinatorRepository, EmployeeRegister next) {
        super(next);
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Event event) {
        Coordinator coordinator = (Coordinator) employee;
        coordinator.setEvent(event);
        return coordinatorRepository.save(coordinator);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Coordinator;
    }
}
