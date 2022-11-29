package com.se3project.service;

import com.se3project.dtos.CollaboratorRegisterDto;
import com.se3project.dtos.EmployeeRegisterDto;
import com.se3project.dtos.EmployeeRegisterOnBarDto;
import com.se3project.dtos.EmployeeRegisterOnEventDto;
import com.se3project.factories.*;
import com.se3project.model.*;
import com.se3project.repository.*;
import com.se3project.service.register.*;
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
    private final LeaderRepository leaderRepository;
    private final AttendantRepository attendantRepository;

    public Event registerOnEvent(CollaboratorRegisterDto dto){
        Event event = getEvent(dto.getEventId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        List<Collaborator> collaborators = event.getCollaborators();
        collaborators.add(collaborator);
        return eventRepository.save(event);
    }

    public Employee registerEmployeeOnEvent(EmployeeRegisterOnEventDto dto) {
        Event event = getEvent(dto.getEventId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        Employee employee = createEmployeeByRole(collaborator, dto);
        return registerEmployeeByRole(employee, event);
    }

    public Employee registerEmployeeOnBar(EmployeeRegisterOnBarDto dto) {
        Bar bar = getBar(dto.getBarId());
        Collaborator collaborator = getCollaborator(dto.getCollaboratorId());
        Employee employee = createEmployeeByRole(collaborator, dto);
        return registerEmployeeByRole(employee, bar);
    }

    //Chain of Responsability and Factory
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
    private Employee registerEmployeeByRole(Employee employee, Registrable registrable){
        EmployeeRegister employeeRegister = new AttendantRegister(attendantRepository,
                new LeaderRegister(leaderRepository,
                        new CoordinatorRegister(coordinatorRepository,
                                new MoutingRegister(moutingRepository,
                                        new DemoutingRegister(demoutingRepository,
                                                null
                                        )
                                )
                        )
                )
        );
        return employeeRegister.register(employee, registrable);
    }

    public Event getEvent(UUID eventId) {
        return eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
    }

    public Collaborator getCollaborator(UUID collaboratorId) {
        return collaboratorRepository.findById(collaboratorId).orElseThrow(RuntimeException::new);
    }

    public Bar getBar(UUID barId){
        return barRepository.findById(barId).orElseThrow(RuntimeException::new);
    }

}
