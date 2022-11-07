package com.se3project.dtos;


import com.se3project.model.Bar;
import com.se3project.model.Collaborator;
import com.se3project.model.Coordinator;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class EventDto {
    UUID id;
    String name;
    List<Coordinator> coordinators;
    List<Bar> bars;
    List<Collaborator> collaborators;

    public EventDto(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.coordinators = builder.coordinators;
        this.bars = builder.bars;
        this.collaborators = builder.collaborators;
    }

    public static class Builder {
        private final UUID id;
        private final String name;
        List<Coordinator> coordinators = List.of();
        List<Bar> bars = List.of();
        List<Collaborator> collaborators = List.of();

        public Builder(UUID id, String name){
            this.id = id;
            this.name = name;
        }

        public Builder coordinators(List<Coordinator> coordinators){
            this.coordinators = coordinators;
            return this;
        }

        public Builder bars(List<Bar> bars){
            this.bars = bars;
            return this;
        }

        public Builder collaborators(List<Collaborator> collaborators){
            this.collaborators = collaborators;
            return this;
        }

        public EventDto build(){
            return new EventDto(this);
        }
    }
}
