package com.se3project.service;

import com.se3project.model.Collaborator;
import com.se3project.repository.CollaboratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;

    public Collaborator create(Collaborator dto){
        Collaborator collaborator = new Collaborator(dto.getName(), dto.getCpf(), dto.getPix());
        collaboratorRepository.save(collaborator);
        return collaborator;
    }

    public Collaborator getCollaborator(UUID collaboratorId) {
        return collaboratorRepository.findById(collaboratorId).orElseThrow(RuntimeException::new);
    }

    public void delete(UUID collaboratorId) {
        Collaborator collaborator = getCollaborator(collaboratorId);
        collaboratorRepository.delete(collaborator);
    }
}
