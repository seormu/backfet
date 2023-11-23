package com.repositorio.repositorio.domain.gateway;

import com.repositorio.repositorio.domain.model.gasto.Gasto;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GastoRepository {
    Mono<Gasto> guardarGasto(Gasto gasto);

    Flux<Gasto> listarGasto();

    Mono<Void> eliminarGasto(Gasto gasto);

    Mono<Gasto> buscarGasto(String id);
}
