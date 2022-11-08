package com.se3project.controller;

import com.se3project.dtos.BarCreateDto;
import com.se3project.model.Bar;
import com.se3project.model.Event;
import com.se3project.service.BarService;
import com.se3project.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/bar")
public class BarController {
    private final BarService barService;

    @PostMapping()
    public ResponseEntity<Bar> create(@RequestBody BarCreateDto dto){
        Bar bar = barService.create(dto);
        return ResponseEntity.ok(bar);
    }

    @GetMapping("{barId}")
    public ResponseEntity<Bar> show(@RequestParam UUID barId){
        Bar bar = barService.getBar(barId);
        return ResponseEntity.ok(bar);
    }

    @DeleteMapping("{barId}")
    public ResponseEntity<Void> delete(@RequestParam UUID barId){
        barService.delete(barId);
        return ResponseEntity.noContent().build();
    }

}
