package com.se3project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {
    @Id
    @Column(name = "employee_id")
    protected UUID id;

    @ManyToOne
    @JoinColumn(name = "collaborator_id", nullable = false)
    private Collaborator collaborator;

    @Column(nullable = false)
    private BigDecimal pay;

    public Employee(Collaborator collaborator, BigDecimal pay){
        this.id = UUID.randomUUID();
        this.collaborator = collaborator;
        this.pay = pay;
    }
}
