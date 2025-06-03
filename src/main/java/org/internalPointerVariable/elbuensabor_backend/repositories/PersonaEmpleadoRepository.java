package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaEmpleadoRepository extends BaseRepository<PersonaEmpleado> {
    Optional<PersonaEmpleado> findByEmail(String email);
    Optional<PersonaEmpleado> findByAuth2Id(String auth2Id);
}
