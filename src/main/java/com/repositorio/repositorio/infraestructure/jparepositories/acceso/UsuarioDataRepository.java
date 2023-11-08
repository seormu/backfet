package com.repositorio.repositorio.infraestructure.jparepositories.acceso;

import com.repositorio.repositorio.infraestructure.jparepositories.acceso.UsuarioData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioDataRepository extends CrudRepository<UsuarioData, Long> {

    @Query(value = "SELECT * FROM usuario WHERE usuario =:usuario AND contrasenia =:contrasenia", nativeQuery = true)
    UsuarioData login(@Param("usuario") String usuario,
                      @Param("contrasenia") String contrasenia);
}
