package com.se3project.controller;

import com.se3project.dtos.BarCreateDto;
import com.se3project.model.Bar;
import com.se3project.model.Collaborator;
import com.se3project.model.Event;
import com.se3project.service.BarService;
import com.se3project.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/event")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event dto){
        Event event = eventService.create(dto);
        return ResponseEntity.ok(event);
    }

    @GetMapping("{eventId}")
    public ResponseEntity<Event> show(@PathVariable UUID eventId){
        Event event = eventService.getEvent(eventId);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("{eventId}")
    public ResponseEntity<Void> delete(@RequestParam UUID eventId){
        eventService.delete(eventId);
        return ResponseEntity.noContent().build();
    }
}
