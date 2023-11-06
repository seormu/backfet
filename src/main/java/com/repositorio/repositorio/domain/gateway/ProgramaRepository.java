package com.repositorio.repositorio.domain.gateway;

import com.repositorio.repositorio.domain.model.programa.Programa;
import reactor.core.publisher.Flux;

public interface ProgramaRepository {
    Flux<Programa> obtenerProgramas();
}
