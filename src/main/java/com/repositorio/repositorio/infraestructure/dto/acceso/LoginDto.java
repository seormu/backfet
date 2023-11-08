package com.repositorio.repositorio.infraestructure.dto.acceso;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginDto {
    private String id;
    private String usuario;
    private String mensaje;
}
