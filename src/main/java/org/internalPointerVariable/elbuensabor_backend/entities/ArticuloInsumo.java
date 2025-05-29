package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ArticuloInsumo extends BaseEntity {

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "es_para_elaborar")
    private Boolean esParaElaborar;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "stock_minimo")
    private Double stockMinimo;

    @ManyToOne
    @JoinColumn(name = "rubro_fk")
    private ArticuloInsumoRubro articuloInsumoRubro;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_fk")
    private UnidadMedida unidadMedida;
}
