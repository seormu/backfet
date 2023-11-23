package com.repositorio.repositorio.infraestructure.jparepositories.proyecto;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "proyectos")
@Table(name = "proyectos")
public class ProyectoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String codigo;
    @Column
    private String nombreProyecto;
    @Column
    private String objetivoGeneral;
    @Column
    private String programa;
    @Column
    private String anio;
    @Column
    private String procedencia;
    @Column
    private String investigadorUno;
    @Column
    private String investigadorDos;
    @Column
    private String investigadorTres;
    @Column
    private String fechaInicio;
    @Column
    private String fechaFin;
    @Column
    private String estado;
    @Column
    private String valorProyecto;
    @Column
    private int cantidadProyectos;
}
