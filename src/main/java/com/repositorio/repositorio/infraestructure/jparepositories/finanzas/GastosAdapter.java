package com.repositorio.repositorio.infraestructure.jparepositories.finanzas;


import com.repositorio.repositorio.domain.gateway.GastoRepository;
import com.repositorio.repositorio.domain.model.gasto.Gasto;
import com.repositorio.repositorio.infraestructure.mapper.GastoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GastosAdapter implements GastoRepository {

    @Autowired
    private final GastosDataRepository repositorioGastos;

    @Autowired
    private final GastoMapper mapeadorGasto;

    @Override
    public Mono<Gasto> guardarGasto(Gasto gasto) {
        return Mono.just(repositorioGastos.save(mapeadorGasto.gastoToGastoData(gasto)))
                .map(mapeadorGasto::gastoDataToGasto);
    }

    @Override
    public Flux<Gasto> listarGasto() {
        return Flux.fromIterable(repositorioGastos.findAll())
                .map(mapeadorGasto::gastoDataToGasto);
    }

    @Override
    public Mono<Void> eliminarGasto(Gasto gasto) {
        repositorioGastos.delete(mapeadorGasto.gastoToGastoData(gasto));
        return Mono.empty();
    }

    @Override
    public Mono<Gasto> buscarGasto(String id) {
        Optional<GastosData> gastosData = repositorioGastos.findById(id);
        return Mono.just(Gasto.builder()
                        .id(gastosData.get().getId())
                        .valorGasto(gastosData.get().getValorGasto())
                        .gasto(gastosData.get().getGasto())
                .build());
    }
}
