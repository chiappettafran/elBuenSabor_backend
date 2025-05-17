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

    @Column(name = "forma_pago")
    private FormaPagoEnum formaPago;

    @Column(name = "total_venta")
    private Double totalVenta;

    @Column(name = "is_pagado")
    private Boolean isPagado;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "datos_mercado_pago_fk")
    private DatosMercadoPago datosMercadoPago;
}
