package com.repositorio.repositorio.domain.usecase.proyecto;

import com.repositorio.repositorio.domain.exception.NoContentException;
import com.repositorio.repositorio.domain.gateway.ProyectoRepository;
import com.repositorio.repositorio.domain.model.Proyecto;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class ProyectoUseCase {

    private final ProyectoRepository repositorioProyecto;

    public Flux<Proyecto> consultarProyectos(){
        return repositorioProyecto.consultarProyectos()
                .onErrorResume(error -> Mono.error(new NoContentException("Error al consultar los proyectos: "+error)));
    }

    public Mono<Proyecto> guardarProyecto(Proyecto proyecto){
        return repositorioProyecto.guardarProyecto(proyecto)
                .onErrorResume(error -> Mono.error(new NoContentException("Error al guardar el proyecto: "+error)));
    }

    public Flux<Proyecto> filtrarProyectos(String filtro){
        return repositorioProyecto.filtarProyectos(filtro);
    }

    public Mono<Proyecto> consultarProyecto(String id){
        return repositorioProyecto.consultarProyecto(id);
    }

    public Mono<Void> eliminarProyecto(String id){
        return repositorioProyecto.consultarProyecto(id)
                .flatMap(proyecto -> repositorioProyecto.eliminarProyecto(proyecto));
    }

}
