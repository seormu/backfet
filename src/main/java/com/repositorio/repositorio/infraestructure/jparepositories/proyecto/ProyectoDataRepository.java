package com.repositorio.repositorio.infraestructure.jparepositories.proyecto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProyectoDataRepository extends CrudRepository<ProyectoData, String> {

    @Query(value = "SELECT * FROM proyectos WHERE CODIGO LIKE %:filtro% OR PROGRAMA LIKE %:filtro%", nativeQuery = true)
    Iterable<ProyectoData> filtarProyectos(@Param("filtro") String filtro);

    @Query(value = "SELECT COUNT(*) FROM proyectos", nativeQuery = true)
    String obtenerCantidadProyectos();

    @Query(value = "SELECT MAX(cantidad_proyectos) FROM proyectos WHERE programa =:programa", nativeQuery = true)
    Optional<String> obtenerValorCantidadProyectos(@Param("programa") String programa);

}
