package com.repositorio.repositorio.domain.gateway;

import com.repositorio.repositorio.domain.model.programa.Programa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProgramaRepository {
    Flux<Programa> obtenerProgramas();

    Mono<String> obtenerCantidadProgramas();
}
