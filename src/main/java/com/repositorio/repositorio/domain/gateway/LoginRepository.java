package com.repositorio.repositorio.domain.gateway;

import com.repositorio.repositorio.domain.model.acceso.Login;
import com.repositorio.repositorio.domain.usecase.acceso.DatosAcceso;
import reactor.core.publisher.Mono;

public interface LoginRepository {
    Mono<Login> login(DatosAcceso datosAcceso);
}
