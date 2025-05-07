package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumo extends BaseEntity {

    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

    @Column(name = "precio_compra", length = 256)
    private Double precioCompra;

    @Column(name = "precio_venta", length = 256)
    private Double precioVenta;

    @Column(name = "es_para_elavorar", length = 256)
    private Boolean esParaElavorar;

    @ManyToOne
    @JoinColumn(name = "rubro_fk")
    private Rubro rubroFK;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_fk")
    private UnidadMedida unidadMedidaFK;
}
