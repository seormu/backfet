package com.repositorio.repositorio.domain.usecase.proyecto;

import com.repositorio.repositorio.domain.exception.NoContentException;
import com.repositorio.repositorio.domain.gateway.ProyectoRepository;
import com.repositorio.repositorio.domain.model.Proyecto;
import com.repositorio.repositorio.domain.model.proyecto.ListaProyectos;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RequiredArgsConstructor
public class ProyectoUseCase {

    private final ProyectoRepository repositorioProyecto;

    public Flux<ListaProyectos> consultarProyectos(){
        return repositorioProyecto.consultarProyectos()
                .map(proyecto -> {
                    System.out.println("id "+proyecto.getId());
                    return ListaProyectos.builder()
                            .id(proyecto.getId())
                            .codigo(proyecto.getCodigo())
                            .nombreProyecto(proyecto.getNombreProyecto())
                            .objetivoGeneral(proyecto.getObjetivoGeneral())
                            .programa(proyecto.getPrograma())
                            .anio(proyecto.getAnio())
                            .procedencia(proyecto.getProcedencia())
                            .investigadorUno(proyecto.getInvestigadorUno())
                            .investigadorDos(proyecto.getInvestigadorDos())
                            .investigadorTres(proyecto.getInvestigadorTres())
                            .fechaInicio(proyecto.getFechaInicio())
                            .fechaFin(proyecto.getFechaFin())
                            .estado(proyecto.getEstado())
                            .valorProyecto(proyecto.getValorProyecto())
                            .cantidadProyectos(proyecto.getCantidadProyectos())
                            .alerta(generarAlerta(proyecto))
                            .build();
                })
                .onErrorResume(error -> Mono.error(new NoContentException("Error al consultar los proyectos: "+error)));
    }

    public String generarAlerta(Proyecto proyecto){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (Objects.nonNull(proyecto.getFechaInicio()) && Objects.nonNull(proyecto.getFechaFin())){
            LocalDate fechaFin = LocalDate.parse(proyecto.getFechaFin(), dateTimeFormatter);
            if (proyecto.getEstado().equals("TERMINADO")){
                return "bg-twitter";
            }else if(LocalDate.now().isBefore(fechaFin.minusDays(10))){
                return "bg-twitter";
            }else if(LocalDate.now().isAfter(fechaFin.minusDays(10)) && LocalDate.now().isBefore(fechaFin)){
                return "bg-warning";
            }
            return "bg-danger";
        }
        return "bg-danger";

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
