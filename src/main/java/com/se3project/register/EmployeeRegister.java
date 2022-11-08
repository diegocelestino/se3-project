package com.se3project.register;

import com.se3project.model.Employee;
import com.se3project.model.Event;

public abstract class EmployeeRegister {
    protected EmployeeRegister next;

    public EmployeeRegister(EmployeeRegister next) {
        this.next = next;
    }

    public Employee register(Employee employee, Event event){
        if (isTheRightInstance(employee)){
            return doRegister(employee, event);
        }
        return next.register(employee, event);
    }
    protected abstract Employee doRegister(Employee employee, Event event);
    protected abstract boolean isTheRightInstance(Employee employee);
}
