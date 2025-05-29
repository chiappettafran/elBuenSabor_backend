package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ArticuloManufacturado extends BaseEntity {

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

    @Column(name = "tiempo_estimado")
    private Integer tiempoEstimado;

    @ManyToOne
    @JoinColumn(name = "rubro_general_fk")
    private ArticuloManufacturadoRubro articuloManufacturadoRubro;

    @OneToMany(mappedBy = "articuloManufacturado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ArticuloManufacturadoDetalle> detalles = new ArrayList<>();
}
