package com.se3project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "collaborators")
public class Collaborator {
    @Id
    @Column(name = "collaborator_id")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String pix;

    @JsonIgnore
    @ManyToMany(mappedBy = "collaborators")
    private List<Event> events;

    @JsonIgnore
    @OneToMany(mappedBy = "collaborator", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Collaborator(String name, String cpf, String pix){
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.pix = pix;
    }
}
