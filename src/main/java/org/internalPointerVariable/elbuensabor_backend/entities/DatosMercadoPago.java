package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.StatusMPEnum;

import java.time.LocalDate;

@Entity
@Table(name = "datos_mercado_pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatosMercadoPago extends BaseEntity {

    @Column(name = "date_approved", length = 256, nullable = false)
    private LocalDate dateApproved;

    @Column(name = "date_last_updated", length = 256, nullable = false)
    private LocalDate dateLastUpdated;

    @Column(name = "mp_merchant_order_id", length = 256, nullable = false)
    private Integer mpMerchantOrderId;

    @Column(name = "mp_preference_id", length = 256, nullable = false)
    private String mpPreferenceId;

    @Column(name = "mp_payment_type", length = 256, nullable = false)
    private String mpPaymentType;

    @Column(name = "mp_payment_id", length = 256, nullable = false)
    private Integer mpPaymentId;

    @Column(name = "status", length = 256, nullable = false)
    private StatusMPEnum status;

    @Column(name = "status_detail", length = 256, nullable = false)
    private String statusDetail;

//    @OneToOne
//    @JoinColumn(name = "factura_fk")
//    private Factura facturaFK;
}
