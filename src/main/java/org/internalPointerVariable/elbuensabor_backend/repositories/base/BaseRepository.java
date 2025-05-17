package org.internalPointerVariable.elbuensabor_backend.repositories.base;

import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity> extends JpaRepository<ENTITY, Long>, JpaSpecificationExecutor<ENTITY> {
}
