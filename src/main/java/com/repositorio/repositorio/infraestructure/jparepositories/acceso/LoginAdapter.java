package com.repositorio.repositorio.infraestructure.jparepositories.acceso;

import com.repositorio.repositorio.domain.exception.NoContentException;
import com.repositorio.repositorio.domain.gateway.LoginRepository;
import com.repositorio.repositorio.domain.model.acceso.Login;
import com.repositorio.repositorio.domain.usecase.acceso.DatosAcceso;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LoginAdapter implements LoginRepository {

    @Autowired
    private UsuarioDataRepository usuarioDataRepository;

    @Override
    public Mono<Login> login(DatosAcceso datosAcceso) {
        return Mono.just(usuarioDataRepository.login(datosAcceso.getUsuario(),datosAcceso.getContrasenia()))
                .flatMap(usuarioData -> Mono.just(Login.builder()
                        .id(usuarioData.getId().toString())
                        .usuario(usuarioData.getUsuario())
                        .mensaje("VALID")
                        .build()))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new NoContentException("INVALID"))))
                .onErrorResume(error -> Mono.error(new NoContentException("ERROR")));

    }
}
