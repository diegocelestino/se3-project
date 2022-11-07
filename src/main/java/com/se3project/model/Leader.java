package com.se3project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leaders")
public class Leader extends Employee {
    private String barReport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bar_id", referencedColumnName = "bar_id")
    private Bar bar;

    public Leader(Collaborator collaborator, BigDecimal pay){
        super(collaborator, pay);
    }

}
