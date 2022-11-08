package com.se3project.factories;

import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Collaborator;
import com.se3project.model.Employee;
import com.se3project.model.Leader;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class LeaderFactory extends EmployeeFactory {

    public LeaderFactory(EmployeeFactory next) {
        super(null);
    }

    @Override
    public Employee doCreate(Collaborator collaborator, EmployeeRegisterOnEventDto dto) {
        return new Leader(collaborator, dto.getPay());
    }

    @Override
    public boolean isTheRightRole(EmployeeRole type) {
        return type.equals(EmployeeRole.LEADER);
    }

}
