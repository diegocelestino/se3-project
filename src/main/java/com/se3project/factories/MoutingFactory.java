package com.se3project.factories;


import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Collaborator;
import com.se3project.model.Employee;
import com.se3project.model.Mouting;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MoutingFactory extends EmployeeFactory {

    public MoutingFactory(EmployeeFactory next) {
        super(next);
    }

    @Override
    public Employee doCreate(Collaborator collaborator, EmployeeRegisterOnEventDto dto) {
        return new Mouting(collaborator, dto.getPay());
    }

    @Override
    public boolean isTheRightRole(EmployeeRole type) {
        return type.equals(EmployeeRole.MOUTING);
    }
}
