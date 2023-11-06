package com.repositorio.repositorio.infraestructure.jparepositories.programas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaDataRepository extends CrudRepository<ProgramaData, String> {
}
