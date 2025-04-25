package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
