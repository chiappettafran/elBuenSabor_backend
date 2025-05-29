package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "articulo_manufacturado_rubro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ArticuloManufacturadoRubro extends BaseEntity {
    @Column(name = "denominacion")
    private String denominacion;
}
