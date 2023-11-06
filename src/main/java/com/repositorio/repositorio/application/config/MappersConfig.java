package com.repositorio.repositorio.application.config;

import com.repositorio.repositorio.infraestructure.mapper.ProgramasMapper;
import com.repositorio.repositorio.infraestructure.mapper.ProyectoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public ProyectoMapper proyectoMapper(){
        return Mappers.getMapper(ProyectoMapper.class);
    }

    @Bean
    public ProgramasMapper programaMapper(){
        return Mappers.getMapper(ProgramasMapper.class);
    }
}
