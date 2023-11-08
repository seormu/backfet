package com.repositorio.repositorio.domain.usecase.acceso;

import com.repositorio.repositorio.domain.gateway.LoginRepository;
import com.repositorio.repositorio.domain.model.acceso.Login;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class LoginUseCase {

    private final LoginRepository loginRepository;

    public Mono<Login> login(DatosAcceso datosAcceso){
        return loginRepository.login(datosAcceso);
    }
}
