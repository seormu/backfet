package com.repositorio.repositorio.infraestructure.jparepositories.programas;

import com.repositorio.repositorio.infraestructure.jparepositories.proyecto.ProyectoData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaDataRepository extends CrudRepository<ProgramaData, String> {

    @Query(value = "SELECT COUNT(*) FROM programas", nativeQuery = true)
    String obtenerCantidadProgramas();
}
