package com.repositorio.repositorio.infraestructure.jparepositories.finanzas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "gastos")
@Table(name = "gastos")
public class GastosData {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String gasto;

    @Column
    private String valorGasto;

}
