package com.se3project.controller;

import com.se3project.model.Collaborator;
import com.se3project.service.CollaboratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/collaborator")
public class CollaboratorController {
    private final CollaboratorService collaboratorService;

    @PostMapping
    public ResponseEntity<Collaborator> create(@RequestBody Collaborator dto){
        Collaborator collaborator = collaboratorService.create(dto);
        return ResponseEntity.ok(collaborator);
    }

    @GetMapping("{collaboratorId}")
    public ResponseEntity<Collaborator> show(@RequestParam UUID collaboratorId){
        Collaborator collaborator = collaboratorService.getCollaborator(collaboratorId);
        return ResponseEntity.ok(collaborator);
    }

    @DeleteMapping("{collaboratorId}")
    public ResponseEntity<Void> delete(@RequestParam UUID collaboratorId){
        collaboratorService.delete(collaboratorId);
        return ResponseEntity.noContent().build();
    }
}
