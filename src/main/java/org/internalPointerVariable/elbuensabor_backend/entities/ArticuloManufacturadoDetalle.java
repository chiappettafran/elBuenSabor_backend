package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "articulo_manufacturado_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalle extends BaseEntity {

    @Column(name = "cantidad", length = 256)
    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_fk")
    private ArticuloInsumo articuloInsumoFK;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado_fk")
    private ArticuloManufacturado articuloManufacturadoFK;
}
