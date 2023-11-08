package com.repositorio.repositorio.domain.gateway;

import com.repositorio.repositorio.domain.model.Proyecto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface ProyectoRepository {

    Flux<Proyecto> consultarProyectos();

    Mono<Proyecto> guardarProyecto(Proyecto proyecto);

    Flux<Proyecto> filtarProyectos(String filtro);

    Mono<Proyecto> consultarProyecto(String id);

    Mono<Void> eliminarProyecto(Proyecto proyecto);

    Mono<Void> actualizarProyecto(Proyecto proyecto);

    Mono<String> obtenerCantidadProyectos();
    Mono<String> complementarId(String programa);

}
