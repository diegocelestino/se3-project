package com.se3project.service;


import com.se3project.dtos.CollaboratorRegisterDto;
import com.se3project.dtos.EmployeeRegisterDto;
import com.se3project.dtos.EmployeeRegisterOnBarDto;
import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.factories.*;
import com.se3project.model.Bar;
import com.se3project.model.Collaborator;
import com.se3project.model.Employee;
import com.se3project.model.Event;
import com.se3project.register.CoordinatorRegister;
import com.se3project.register.DemoutingRegister;
import com.se3project.register.EmployeeRegister;
import com.se3project.register.MoutingRegister;
import com.se3project.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffService {
    private final EventRepository eventRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final CoordinatorRepository coordinatorRepository;
    private final MoutingRepository moutingRepository;
    private final DemoutingRepository demoutingRepository;
    private final BarRepository barRepository;


    public Event registerOnEvent(CollaboratorRegisterDto dto){
        Event event = getEvent(dto.getEventId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        List<Collaborator> collaborators = event.getCollaborators();
        checkIfCollaboratorIsAlreadyRegistered(collaborator, collaborators);
        collaborators.add(collaborator);
        return eventRepository.save(event);
    }

    public Employee registerEmployeeOnEvent(EmployeeRegisterOnEventDto dto) {
        Event event = getEvent(dto.getEventId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        Employee employee = createEmployeeByRole(collaborator, dto);
        return registerEmployeeOnEventByRole(employee, event);
    }

    public Employee registerEmployeeOnBar(EmployeeRegisterOnBarDto dto) {
        Bar bar = getBar(dto.getBarId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        Employee employee = createEmployeeByRole(collaborator, dto);
        return employee;
    }

    //Chain of Responsability
    private Employee createEmployeeByRole(Collaborator collaborator, EmployeeRegisterDto dto){
        EmployeeFactory employeeFactory = new CoordinatorFactory(
                new MoutingFactory(
                        new DemoutingFactory(
                                new LeaderFactory(
                                        new AttendantFactory(
                                                null
                                        )
                                )
                        )
                )
        );
        return employeeFactory.create(collaborator, dto);
    }


    //Template
    private Employee registerEmployeeOnEventByRole(Employee employee, Event event){
        EmployeeRegister employeeRegister = new CoordinatorRegister(coordinatorRepository,
                new MoutingRegister(moutingRepository,
                        new DemoutingRegister(demoutingRepository,
                                null
                        )
                )
        );
        return employeeRegister.register(employee, event);
    }


    private Employee registerEmployeeOnBarByRole(Employee employee, Bar bar){
        EmployeeRegister employeeRegister = new CoordinatorRegister(coordinatorRepository,
                new MoutingRegister(moutingRepository,
                        new DemoutingRegister(demoutingRepository,
                                null
                        )
                )
        );
        return employeeRegister.register(employee, event);
    }


    public Event getEvent(UUID eventId) {
        return eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
    }

    public Collaborator getCollaborator(UUID collaboratorId) {
        return collaboratorRepository.findById(collaboratorId).orElseThrow(RuntimeException::new);
    }

    private void checkIfCollaboratorIsAlreadyRegistered(Collaborator collaborator, List<Collaborator> collaborators) {
        if (collaborators.contains(collaborator)){
            throw new RuntimeException();
        }
    }

    private void checkIfCollaboratorIsNotRegistered(Collaborator collaborator, List<Collaborator> collaborators) {
        if (!collaborators.contains(collaborator)){
            throw new RuntimeException();
        }
    }

    public Bar getBar(UUID barId){
        return barRepository.findById(barId).orElseThrow(RuntimeException::new);
    }

}
