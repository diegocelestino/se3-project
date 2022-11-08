package com.se3project.register;

import com.se3project.model.Coordinator;
import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.model.Leader;
import com.se3project.repository.CoordinatorRepository;
import com.se3project.repository.LeaderRepository;

public class LeaderRegister extends EmployeeRegister {
    private final LeaderRepository leaderRepository;

    public LeaderRegister(LeaderRepository leaderRepository, EmployeeRegister next) {
        super(next);
        this.leaderRepository = leaderRepository;
    }

    @Override
    public Employee doRegister(Employee employee, Event event) {
        Leader leader = (Leader) employee;
        leader.setEvent(event);
        return leaderRepository.save(coordinator);
    }

    @Override
    protected boolean isTheRightInstance(Employee employee) {
        return employee instanceof Coordinator;
    }
}
