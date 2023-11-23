package com.repositorio.repositorio.infraestructure.mapper;

import com.repositorio.repositorio.domain.model.gasto.Gasto;
import com.repositorio.repositorio.infraestructure.dto.gastos.GastosDto;
import com.repositorio.repositorio.infraestructure.jparepositories.finanzas.GastosData;
import org.mapstruct.Mapper;

@Mapper
public interface GastoMapper {

    Gasto obtrenerEntidad(GastosDto gastosDto);
    GastosDto ObtenerDto(Gasto gasto);

    GastosData gastoToGastoData(Gasto gasto);

    Gasto gastoDataToGasto(GastosData gastosData);
}
