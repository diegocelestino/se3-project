package com.se3project.service.register;

import com.se3project.model.*;
import com.se3project.repository.LeaderRepository;

public class LeaderRegister extends EmployeeRegister {
    private final LeaderRepository leaderRepository;

    public LeaderRegister(LeaderRepository leaderRepository, EmployeeRegister next) {
        super(next);
        this.leaderRepository = leaderRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Registrable bar) {
        Leader leader = (Leader) employee;
        leader.setBar((Bar) bar);
        return leaderRepository.save(leader);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Leader;
    }
}
