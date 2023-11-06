package com.repositorio.repositorio.infraestructure.dto.programa;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ProgramaDto {

    private String id;
    private String carrera;
    private String pronombre;
}
