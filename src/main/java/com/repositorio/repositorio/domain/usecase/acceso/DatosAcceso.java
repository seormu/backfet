package com.repositorio.repositorio.domain.usecase.acceso;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class DatosAcceso {
    private String usuario;
    private String contrasenia;
}
