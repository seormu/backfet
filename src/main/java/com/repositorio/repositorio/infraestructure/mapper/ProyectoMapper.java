package com.repositorio.repositorio.infraestructure.mapper;

import com.repositorio.repositorio.domain.model.Proyecto;
import com.repositorio.repositorio.infraestructure.dto.proyectos.ProyectoDto;
import com.repositorio.repositorio.infraestructure.jparepositories.proyecto.ProyectoData;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface ProyectoMapper {

    ProyectoDto obtenerDto(Proyecto proyecto);

    Proyecto obtenerEntidad(ProyectoDto proyecto);

    Proyecto proyectoDataToProyecto(ProyectoData proyectoData);

    ProyectoData proyectoToProyectoData(Proyecto proyecto);


}
