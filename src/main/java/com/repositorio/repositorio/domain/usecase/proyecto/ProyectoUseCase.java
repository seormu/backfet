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

    public Mono<Void> actualizarProyecto(Proyecto proyecto, String id){
        proyecto.setId(id);
        return repositorioProyecto.actualizarProyecto(proyecto);
    }

    public Mono<String> obtenerCantidadProyectos(){
        return repositorioProyecto.obtenerCantidadProyectos();
    }

    public Mono<String> complementarId(String programa){
        return repositorioProyecto.complementarId(programa)
                .flatMap(valor -> {
                     Integer conversion = Integer.parseInt(valor);
                     Integer suma = conversion+1;
                    return Mono.just(suma.toString());
                });
    }

}
