package com.repositorio.repositorio.infraestructure.mapper;

import com.repositorio.repositorio.domain.model.acceso.Login;
import com.repositorio.repositorio.domain.usecase.acceso.DatosAcceso;
import com.repositorio.repositorio.infraestructure.dto.acceso.DatosAccesoDto;
import com.repositorio.repositorio.infraestructure.dto.acceso.LoginDto;
import org.mapstruct.Mapper;

@Mapper
public interface LoginMapper {

    LoginDto obtenerDtoLogin(Login login);

    DatosAcceso obtenerEntidadDatosAcceso(DatosAccesoDto datosAccesoDto);
}
