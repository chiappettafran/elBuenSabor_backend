package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntityDetalle;

@Entity
@Table(name = "pedido_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDetalle extends BaseEntityDetalle {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "pedido_fk")
    private Pedido pedido;

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
