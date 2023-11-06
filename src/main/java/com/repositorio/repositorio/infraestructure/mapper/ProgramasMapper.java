package com.repositorio.repositorio.infraestructure.mapper;

import com.repositorio.repositorio.domain.model.programa.Programa;
import com.repositorio.repositorio.infraestructure.dto.programa.ProgramaDto;
import com.repositorio.repositorio.infraestructure.jparepositories.programas.ProgramaData;
import org.mapstruct.Mapper;

@Mapper
public interface ProgramasMapper {

    ProgramaDto obtenerDto(Programa programa);
    Programa programaDataToPrograma(ProgramaData programaData);
}
