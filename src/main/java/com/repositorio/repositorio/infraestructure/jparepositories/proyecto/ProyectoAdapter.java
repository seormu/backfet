package com.repositorio.repositorio.infraestructure.jparepositories.proyecto;

import com.repositorio.repositorio.domain.exception.NoContentException;
import com.repositorio.repositorio.domain.gateway.ProyectoRepository;
import com.repositorio.repositorio.domain.model.Proyecto;
import com.repositorio.repositorio.infraestructure.mapper.ProyectoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static java.util.Optional.*;

@Component
@RequiredArgsConstructor
public class ProyectoAdapter implements ProyectoRepository {

    @Autowired
    private final ProyectoDataRepository dataRepository;

    @Autowired
    private final ProyectoMapper mapeadorProyecto;

    @Override
    public Flux<Proyecto> consultarProyectos() {
        return Flux.fromIterable(dataRepository.findAll())
                .map(mapeadorProyecto::proyectoDataToProyecto);
    }

    @Override
    public Mono<Proyecto> guardarProyecto(Proyecto proyecto) {
        return Mono.just(dataRepository.save(mapeadorProyecto.proyectoToProyectoData(proyecto)))
                .map(mapeadorProyecto::proyectoDataToProyecto);
    }

    @Override
    public Flux<Proyecto> filtarProyectos(String filtro) {
        return Flux.fromIterable(dataRepository.filtarProyectos(filtro))
                .map(mapeadorProyecto::proyectoDataToProyecto);
    }

    @Override
    public Mono<Proyecto> consultarProyecto(String id) {
        Optional<ProyectoData> proyectoData = dataRepository.findById(id);
        return Mono.just(Proyecto.builder()
                .id(proyectoData.get().getId())
                .codigo(proyectoData.get().getCodigo())
                .nombreProyecto(proyectoData.get().getNombreProyecto())
                .objetivoGeneral(proyectoData.get().getObjetivoGeneral())
                .programa(proyectoData.get().getPrograma())
                .anio(proyectoData.get().getAnio())
                .procedencia(proyectoData.get().getProcedencia())
                .investigadorUno(proyectoData.get().getInvestigadorUno())
                .investigadorDos(proyectoData.get().getInvestigadorDos())
                .investigadorTres(proyectoData.get().getInvestigadorTres())
                .fechaInicio(proyectoData.get().getFechaInicio())
                .fechaFin(proyectoData.get().getFechaFin())
                .estado(proyectoData.get().getEstado())
                .valorProyecto(proyectoData.get().getValorProyecto())
                .build());
    }

    @Override
    public Mono<Void> eliminarProyecto(Proyecto proyecto) {
        dataRepository.delete(mapeadorProyecto.proyectoToProyectoData(proyecto));
        return Mono.empty();
    }

    @Override
    public Mono<Void> actualizarProyecto(Proyecto proyecto) {
        dataRepository.save(mapeadorProyecto.proyectoToProyectoData(proyecto));
        return Mono.empty();
    }

    @Override
    public Mono<String> obtenerCantidadProyectos() {
        return Mono.just(dataRepository.obtenerCantidadProyectos());
    }

    @Override
    public Mono<String> complementarId(String programa) {
        Optional<String> valor = dataRepository.obtenerValorCantidadProyectos(programa);
        if (valor.isEmpty()){
            return Mono.just("0");
        }
        return Mono.just(valor.get());
    }
}
