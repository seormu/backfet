package com.repositorio.repositorio.domain.model.gasto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Gasto {
    private String id;
    private String gasto;
    private String valorGasto;
}
