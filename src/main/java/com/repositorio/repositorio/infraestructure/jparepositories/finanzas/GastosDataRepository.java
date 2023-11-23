package com.repositorio.repositorio.infraestructure.jparepositories.finanzas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosDataRepository extends CrudRepository<GastosData, String> {
}
