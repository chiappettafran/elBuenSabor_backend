package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "articulo_insumo_rubro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ArticuloInsumoRubro extends BaseEntity {

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "rubro_padre")
    private ArticuloInsumoRubro rubroPadre;
}