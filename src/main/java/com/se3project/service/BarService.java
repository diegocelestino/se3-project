package com.se3project.service;

import com.se3project.dtos.BarCreateDto;
import com.se3project.model.Bar;
import com.se3project.model.Event;
import com.se3project.repository.BarRepository;
import com.se3project.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BarService {
    private final BarRepository barRepository;
    private final EventRepository eventRepository;

    public Bar create(BarCreateDto dto){
        Event event = getEvent(dto.getEventId());
        Bar bar = new Bar(dto.getName());
        bar.setEvent(event);
        barRepository.save(bar);
        return bar;
    }

    public void delete(UUID barId) {
        Bar bar = getBar(barId);
        barRepository.delete(bar);
    }

    public Bar getBar(UUID barId){
        return barRepository.findById(barId).orElseThrow(RuntimeException::new);
    }
    public Event getEvent(UUID eventId){
        return eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
    }

}
