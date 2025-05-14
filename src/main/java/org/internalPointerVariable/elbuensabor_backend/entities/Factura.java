package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends BaseEntity {

    @Column(name = "fecha_facturacion", length = 256, nullable = false)
    private OffsetDateTime fechaFacturacion; //Este atributo tambien se puede obviar


    @Column(name = "porcentaje_descuento", length = 256, nullable = false)
    private Integer porcentajeDescuento;

    @Column(name = "forma_pago", length = 256, nullable = false)
    private FormaPagoEnum formaPago;

    @Column(name = "total_venta", length = 256, nullable = false)
    private Double totalVenta;

    @OneToOne
    @JoinColumn(name = "pedido_fk")
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "datos_mercado_pago_fk")
    private DatosMercadoPago datosMercadoPago;
}
