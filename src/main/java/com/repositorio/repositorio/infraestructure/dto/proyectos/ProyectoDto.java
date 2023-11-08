package com.repositorio.repositorio.infraestructure.dto.proyectos;

import com.repositorio.repositorio.infraestructure.dto.programa.ProgramaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProyectoDto {

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
    private String duracion;
    private String valorProyecto;
    private int cantidadProyectos;
}
