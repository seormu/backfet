package com.repositorio.repositorio.infraestructure.dto.gastos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GastosDto {
    private String id;
    private String gasto;
    private String valorGasto;
}
