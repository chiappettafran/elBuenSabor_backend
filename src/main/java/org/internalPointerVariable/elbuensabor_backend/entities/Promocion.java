package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "promocion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Promocion extends BaseEntity {

    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @Column(name = "fecha_desde", length = 256)
    private LocalDate fechaDesde;

    @Column(name = "fecha_hasta", length = 256)
    private LocalDate fechaHasta;

    @Column(name = "descuento", length = 256)
    private Double descuento;

    @OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePromocion> detalles;
}
