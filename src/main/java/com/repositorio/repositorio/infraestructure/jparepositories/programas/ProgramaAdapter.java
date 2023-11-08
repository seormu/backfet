package com.repositorio.repositorio.infraestructure.jparepositories.programas;

import com.repositorio.repositorio.domain.gateway.ProgramaRepository;
import com.repositorio.repositorio.domain.model.programa.Programa;
import com.repositorio.repositorio.infraestructure.mapper.ProgramasMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProgramaAdapter implements ProgramaRepository {

    @Autowired
    private ProgramaDataRepository dataRepository;

    @Autowired
    private ProgramasMapper mapeadorProgramas;

    @Override
    public Flux<Programa> obtenerProgramas() {
        return Flux.fromIterable(dataRepository.findAll())
                .map(mapeadorProgramas::programaDataToPrograma);
    }

    @Override
    public Mono<String> obtenerCantidadProgramas() {
        return Mono.just(dataRepository.obtenerCantidadProgramas());
    }
}
