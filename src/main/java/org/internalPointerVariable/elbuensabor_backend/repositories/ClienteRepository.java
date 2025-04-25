package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
