package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "rubro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumoRubro extends BaseEntity {

    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "rubro_padre")
    private ArticuloInsumoRubro rubroPadre;
}