package org.internalPointerVariable.elbuensabor_backend.repositories;

import org.internalPointerVariable.elbuensabor_backend.entities.CategoriaInstrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaInstrumentoRepository extends JpaRepository<CategoriaInstrumento, Long> {
}
