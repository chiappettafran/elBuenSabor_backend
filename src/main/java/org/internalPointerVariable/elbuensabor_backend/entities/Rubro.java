package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rubro extends BaseEntity {

    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "rubro_padre")
    private Rubro rubroPadre;
}