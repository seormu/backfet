package com.repositorio.repositorio.infraestructure.controllers.gastos;

import com.repositorio.repositorio.domain.usecase.gasto.GastoUseCase;
import com.repositorio.repositorio.infraestructure.dto.gastos.GastosDto;
import com.repositorio.repositorio.infraestructure.mapper.GastoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class GastosCtr {

    private final GastoMapper mapeadorGastos;
    private final GastoUseCase useCaseGasto;

    @PostMapping(value = "guardar-gasto")
    public Mono<GastosDto> guardarGasto(@RequestBody GastosDto gastos){
        return useCaseGasto.guardarGasto(mapeadorGastos.obtrenerEntidad(gastos))
                .map(mapeadorGastos::ObtenerDto);
    }

    @GetMapping(value = "listar-gastos")
    public Flux<GastosDto> listarGastos(){
        return useCaseGasto.listarGasto()
                .map(mapeadorGastos::ObtenerDto);
    }

    @DeleteMapping(value = "eliminar-gasto/{id}")
    public Mono<Void> eliminarGasto(@PathVariable String id){
        return useCaseGasto.eliminarGasto(id);
    }

    @GetMapping("buscar-gasto/{id}")
    public Mono<GastosDto> buscarGasto(@PathVariable String id){
        return useCaseGasto.buscarGasto(id)
                .map(mapeadorGastos::ObtenerDto);
    }
}
