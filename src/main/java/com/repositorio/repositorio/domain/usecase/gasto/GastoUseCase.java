package com.repositorio.repositorio.domain.usecase.gasto;

import com.repositorio.repositorio.domain.exception.NoContentException;
import com.repositorio.repositorio.domain.gateway.GastoRepository;
import com.repositorio.repositorio.domain.model.gasto.Gasto;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GastoUseCase {

    private final GastoRepository repositorioGasto;

    public Mono<Gasto> guardarGasto(Gasto gasto){
        return repositorioGasto.guardarGasto(gasto)
                .onErrorResume(error -> Mono.error(new NoContentException("Error al guardar el gasto")));
    }

    public Flux<Gasto> listarGasto(){
        return repositorioGasto.listarGasto()
                .onErrorResume(error -> Mono.error(new NoContentException("Ocurrio un error al listar los gastos")));
    }

    public Mono<Void> eliminarGasto(String id){
        return repositorioGasto.buscarGasto(id)
                .map(repositorioGasto::eliminarGasto)
                .block();
    }

    public Mono<Gasto> buscarGasto(String id){
        return repositorioGasto.buscarGasto(id)
                .onErrorResume(error -> Mono.error(new NoContentException("Ocurrio un error al buscar el   gasto")));
    }
}
