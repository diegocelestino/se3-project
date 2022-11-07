package com.se3project.factories;

import com.se3project.dtos.EmployeeRegisterDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Collaborator;
import com.se3project.model.Demouting;
import com.se3project.model.Employee;
import com.softwareengineering3.collaborator.Collaborator;
import com.softwareengineering3.employee.Employee;
import com.softwareengineering3.employee.EmployeeFactory;
import com.softwareengineering3.employee.EmployeeRegisterDto;
import com.softwareengineering3.employee.EmployeeRole;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DemoutingFactory extends EmployeeFactory {

    public DemoutingFactory(EmployeeFactory next) {
        super(next);
    }

    @Override
    public Employee doCreate(Collaborator collaborator, EmployeeRegisterDto dto) {
        return new Demouting(collaborator, dto.getPay());
    }

    @Override
    public boolean isTheRightRole(EmployeeRole type) {
        return type.equals(EmployeeRole.DEMOUTING);
    }
}
