package com.repositorio.repositorio.domain.usecase.programas;

import com.repositorio.repositorio.domain.gateway.ProgramaRepository;
import com.repositorio.repositorio.domain.model.programa.Programa;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ProgramasUseCase {

    private final ProgramaRepository repository;

    public Flux<Programa> obtenerProgramas(){
        return repository.obtenerProgramas();
    }
}
