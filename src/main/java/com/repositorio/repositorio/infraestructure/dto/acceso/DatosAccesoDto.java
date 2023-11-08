package com.repositorio.repositorio.infraestructure.dto.acceso;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class DatosAccesoDto {

    private String usuario;
    private String contrasenia;
}
