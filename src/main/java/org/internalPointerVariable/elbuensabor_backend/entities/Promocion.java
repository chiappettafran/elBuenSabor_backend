package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promocion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Promocion extends BaseEntity {

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "fecha_desde")
    private OffsetDateTime fechaDesde;

    @Column(name = "fecha_hasta")
    private OffsetDateTime fechaHasta;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "descuento")
    private Double descuento;

    @OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PromocionDetalle> detalles = new ArrayList<>();;
}
