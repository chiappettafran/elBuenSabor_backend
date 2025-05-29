package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntityDetalle;

@Entity
@Table(name = "articulo_manufacturado_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalle extends BaseEntityDetalle {

    @Column(name = "cantidad")
    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_fk")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado_fk")
    private ArticuloManufacturado articuloManufacturado;
}
