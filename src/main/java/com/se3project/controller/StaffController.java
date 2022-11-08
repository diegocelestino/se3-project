package com.se3project.controller;


import com.se3project.dtos.CollaboratorRegisterDto;
import com.se3project.dtos.EmployeeRegisterOnBarDto;
import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/staff")
public class StaffController {
    private final StaffService staffService;

    @PostMapping("register")
    public ResponseEntity<Event> registerOnEvent(@RequestBody CollaboratorRegisterDto dto){
        Event event = staffService.registerOnEvent(dto);
        return ResponseEntity.ok(event);
    }

    @PostMapping("registerOnEvent")
    public ResponseEntity<Employee> registerEmployeeOnEvent(@RequestBody EmployeeRegisterOnEventDto dto){
        Employee employee = staffService.registerEmployeeOnEvent(dto);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("registerOnBar")
    public ResponseEntity<Employee> registerEmployeeOnBar(@RequestBody EmployeeRegisterOnBarDto dto){
        Employee employee = staffService.registerEmployeeOnBar(dto);
        return ResponseEntity.ok(employee);
    }

}
