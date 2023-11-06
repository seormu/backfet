package com.repositorio.repositorio.infraestructure.controllers.proyectos;

import com.repositorio.repositorio.domain.usecase.proyecto.ProyectoUseCase;
import com.repositorio.repositorio.infraestructure.mapper.ProyectoMapper;
import com.repositorio.repositorio.infraestructure.dto.proyectos.ProyectoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class ProyectosCtr {

    private final ProyectoMapper mapeadorProyecto;

    private final ProyectoUseCase useCase;

    @GetMapping(value = "/listarProyectos")
    public Flux<ProyectoDto> listarProyectos(){
        return useCase.consultarProyectos()
                .map(mapeadorProyecto::obtenerDto);
    }

    @PostMapping(value = "/guardar-proyecto")
    public Mono<ProyectoDto> guardarProyecto(@RequestBody ProyectoDto proyectoDto){
        return useCase.guardarProyecto(mapeadorProyecto.obtenerEntidad(proyectoDto))
                .map(mapeadorProyecto::obtenerDto);
    }

    @GetMapping("filtrar/{filtro}")
    public Flux<ProyectoDto> filtrarProyectos(@PathVariable String filtro){
        return useCase.filtrarProyectos(filtro)
                .map(mapeadorProyecto::obtenerDto);
    }

    @GetMapping("detalle/{id}")
    public Mono<ProyectoDto> consultarProyecto(@PathVariable String id){
        return useCase.consultarProyecto(id)
                .map(mapeadorProyecto::obtenerDto);
    }

    @DeleteMapping("eliminar/{id}")
    public Mono<Void> eliminarProyecto(@PathVariable String id ){
        return useCase.eliminarProyecto(id);
    }

}