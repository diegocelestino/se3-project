package com.se3project.service.register;

import com.se3project.model.Employee;
import com.se3project.model.Registrable;

public abstract class EmployeeRegister {
    protected EmployeeRegister next;

    public EmployeeRegister(EmployeeRegister next) {
        this.next = next;
    }

    public Employee register(Employee employee, Registrable registrable){
        if (isTheRightInstance(employee)){
            return doRegister(employee, registrable);
        }
        return next.register(employee, registrable);
    }
    protected abstract Employee doRegister(Employee employee, Registrable registrable);
    protected abstract boolean isTheRightInstance(Employee employee);

}
