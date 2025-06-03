package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.PersonaCliente;
import org.internalPointerVariable.elbuensabor_backend.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaClienteRepository extends BaseRepository<PersonaCliente> {
    Optional<PersonaCliente> findByEmail(String email);
    Optional<PersonaCliente> findByAuth2Id(String auth2Id);
}
