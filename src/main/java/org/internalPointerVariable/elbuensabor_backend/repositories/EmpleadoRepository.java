package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<PersonaEmpleado> {
}
