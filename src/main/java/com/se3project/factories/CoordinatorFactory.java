package com.se3project.factories;

import com.se3project.dtos.EmployeeRegisterDto;
import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Collaborator;
import com.se3project.model.Coordinator;
import com.se3project.model.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CoordinatorFactory extends EmployeeFactory {

    public CoordinatorFactory(EmployeeFactory next) {
        super(next);
    }

    @Override
    public Employee doCreate(Collaborator collaborator, EmployeeRegisterDto dto) {
        return new Coordinator(collaborator, dto.getPay());
    }

    @Override
    public boolean isTheRightRole(EmployeeRole type) {
        return type.equals(EmployeeRole.COORDINATOR);
    }
}
