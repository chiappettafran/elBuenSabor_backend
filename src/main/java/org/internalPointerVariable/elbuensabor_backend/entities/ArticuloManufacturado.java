package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturado extends BaseEntity {

    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

    @Column(name = "precio_compra", length = 256)
    private Double precioCompra;

    @Column(name = "precio_venta", length = 256)
    private Double precioVenta;

    @Column(name = "tiempo_estimado", length = 256)
    private Integer tiempoEstimado;

    @ManyToOne
    @JoinColumn(name = "rubro_general_fk")
    private RubroGeneral rubroGeneral;

    @OneToMany(mappedBy = "articulo_manufacturado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ArticuloManufacturadoDetalle> detalles;
}
