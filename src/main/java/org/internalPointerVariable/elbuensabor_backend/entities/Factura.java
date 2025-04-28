package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;

import java.time.LocalDate;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends BaseEntity {

    @Column(name = "fecha_facturacion", length = 256, nullable = false)
    private LocalDate fechaFacturacion; //Este atributo tambien se puede obviar

    @Column(name = "mp_payment_id", length = 256, nullable = false)
    private Integer mpPaymentId;

    @Column(name = "mp_merchant_order_id", length = 256, nullable = false)
    private Integer mpMerchantOrderId;

    @Column(name = "mp_preference_id", length = 256, nullable = false)
    private String mpPreferenceId;

    @Column(name = "mp_payment_type", length = 256, nullable = false)
    private String mpPaymentType;

    @Column(name = "forma_pago", length = 256, nullable = false)
    private FormaPagoEnum formaPago;

    @Column(name = "total_venta", length = 256, nullable = false)
    private Double totalVenta;

    @OneToOne
    @JoinColumn(name = "pedido_fk")
    private Pedido pedido;
}
