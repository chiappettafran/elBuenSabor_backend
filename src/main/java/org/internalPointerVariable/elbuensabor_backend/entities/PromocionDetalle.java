package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntityDetalle;

@Entity
@Table(name = "promocion_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromocionDetalle extends BaseEntityDetalle {

    @Column(name = "cantidad", length = 256)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_fk")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado_fk")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    @JoinColumn(name = "promocion_fk")
    private Promocion promocion;
}
