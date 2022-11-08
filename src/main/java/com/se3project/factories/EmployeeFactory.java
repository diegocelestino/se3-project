package com.se3project.factories;



import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.enums.EmployeeRole;
import com.se3project.model.Collaborator;
import com.se3project.model.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public abstract class EmployeeFactory {
    protected EmployeeFactory next;

    public EmployeeFactory(EmployeeFactory next) {
        this.next = next;
    }

    public Employee create(Collaborator collaborator, EmployeeRegisterOnEventDto dto){
        if(isTheRightRole(dto.getEmployeeRole())){
            return doCreate(collaborator, dto);
        }
        return next.create(collaborator, dto);
    }

    public abstract Employee doCreate(Collaborator collaborator, EmployeeRegisterOnEventDto dto);
    public abstract boolean isTheRightRole(EmployeeRole type);

}
