package com.repositorio.repositorio.infraestructure.controllers.acceso;

import com.repositorio.repositorio.domain.usecase.acceso.LoginUseCase;
import com.repositorio.repositorio.infraestructure.dto.acceso.DatosAccesoDto;
import com.repositorio.repositorio.infraestructure.dto.acceso.LoginDto;
import com.repositorio.repositorio.infraestructure.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class LoginCtr {

    private final LoginMapper mapeadorLogin;

    private final LoginUseCase useCaseLogin;

    @PostMapping("/login")
    public Mono<LoginDto> login(@RequestBody DatosAccesoDto datosAccesoDto){
        return useCaseLogin.login(mapeadorLogin.obtenerEntidadDatosAcceso(datosAccesoDto))
                .map(mapeadorLogin::obtenerDtoLogin);
    }

}
