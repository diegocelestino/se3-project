package com.se3project.service;

import com.se3project.model.Event;
import com.se3project.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public Event create(Event dto){
        Event event = new Event(dto.getName());
        eventRepository.save(event);
        return event;
    }

    public Event getEvent(UUID eventId) {
        return eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
    }

    public void delete(UUID eventId) {
        Event event = getEvent(eventId);
        eventRepository.delete(event);
    }
}
