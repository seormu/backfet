package com.repositorio.repositorio.domain.model.acceso;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Login {
    private String id;
    private String usuario;
    private String mensaje;
}
