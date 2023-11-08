package com.repositorio.repositorio.application.config;

import com.repositorio.repositorio.domain.gateway.ProgramaRepository;
import com.repositorio.repositorio.domain.gateway.ProyectoRepository;
import com.repositorio.repositorio.domain.usecase.acceso.LoginUseCase;
import com.repositorio.repositorio.domain.usecase.programas.ProgramasUseCase;
import com.repositorio.repositorio.domain.usecase.proyecto.ProyectoUseCase;
import com.repositorio.repositorio.infraestructure.jparepositories.acceso.LoginAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProyectoUseCase proyectoUseCase(ProyectoRepository proyectoRepository){
        return new ProyectoUseCase(proyectoRepository);
    }

    @Bean
    public ProgramasUseCase programaUseCase(ProgramaRepository programaRepository){
        return new ProgramasUseCase(programaRepository);
    }

    @Bean
    public LoginUseCase loginUseCase(LoginAdapter loginAdapter){
        return new LoginUseCase(loginAdapter);
    }
}
