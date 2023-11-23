package com.repositorio.repositorio.infraestructure.controllers.proyectos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ListaProyectosDto {
    private String id;
    private String codigo;
    private String nombreProyecto;
    private String objetivoGeneral;
    private String programa;
    private String anio;
    private String procedencia;
    private String investigadorUno;
    private String investigadorDos;
    private String investigadorTres;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private String valorProyecto;
    private int cantidadProyectos;
    private String alerta;
}
