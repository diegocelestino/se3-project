package com.se3project.register;

import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.model.Mouting;
import com.se3project.repository.MoutingRepository;

public class MoutingRegister extends EmployeeRegister {
    private final MoutingRepository moutingRepository;

    public MoutingRegister(MoutingRepository moutingRepository, EmployeeRegister next) {
        super(next);
        this.moutingRepository = moutingRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Event event) {
        Mouting  mouting = (Mouting) employee;
        mouting.setEvent(event);
        return moutingRepository.save(mouting);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Mouting;
    }
}
