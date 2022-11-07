package com.se3project.factories;

import com.se3project.dtos.EmployeeRegisterDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Attendant;
import com.se3project.model.Collaborator;
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
public class AttendantFactory extends EmployeeFactory {

    public AttendantFactory(EmployeeFactory next) {
        super(next);
    }

    @Override
    public Employee doCreate(Collaborator collaborator, EmployeeRegisterDto dto) {
        return new Attendant(collaborator, dto.getPay());
    }


    @Override
    public boolean isTheRightRole(EmployeeRole type) {
        return type.equals(EmployeeRole.ATTENDANT);
    }
}
