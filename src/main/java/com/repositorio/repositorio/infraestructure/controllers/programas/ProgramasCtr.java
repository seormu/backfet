package com.repositorio.repositorio.infraestructure.controllers.programas;

import com.repositorio.repositorio.domain.usecase.programas.ProgramasUseCase;
import com.repositorio.repositorio.infraestructure.dto.programa.ProgramaDto;
import com.repositorio.repositorio.infraestructure.mapper.ProgramasMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class ProgramasCtr {

    private final ProgramasUseCase programasUseCase;

    private final ProgramasMapper programasMapeador;

    @GetMapping("/programas")
    public Flux<ProgramaDto> obtrenerProgramas(){
        return programasUseCase.obtenerProgramas()
                .map(programasMapeador::obtenerDto);
    }
}
