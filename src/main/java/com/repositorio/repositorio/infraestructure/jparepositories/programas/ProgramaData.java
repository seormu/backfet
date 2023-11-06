package com.repositorio.repositorio.infraestructure.jparepositories.programas;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "programas")
@Table(name = "programas")
public class ProgramaData {

    @Id
    private String id;
    @Column
    private String carrera;
    @Column
    private String pronombre;
}
