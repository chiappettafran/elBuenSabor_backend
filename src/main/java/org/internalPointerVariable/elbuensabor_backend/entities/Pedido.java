package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.EstadoPedidoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.TipoEnvioEnum;

import java.time.OffsetTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends BaseEntity {


    @Column(name = "hora_inicio_preparacion")
    private OffsetTime horaInicioPreparacion;

    @Column(name = "hora_fin_preparacion")
    private OffsetTime horaFinPreparacion;

    @Column(name = "total")
    private Double total;

    @Column(name = "total_costo")
    private Double totalCosto;

    @Column(name = "estado")
    private EstadoPedidoEnum estado;

    @Column(name = "tipo_envio")
    private TipoEnvioEnum tipoEnvio;

    @Column(name = "forma_pago")
    private FormaPagoEnum formaPago;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_fk")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "cliente_fk")
    private PersonaCliente cliente;

    @ManyToOne
    @JoinColumn(name = "cajero_fk")
    private PersonaEmpleado cajero;

    @ManyToOne
    @JoinColumn(name = "cocinero_fk")
    private PersonaEmpleado cocinero;

    @ManyToOne
    @JoinColumn(name = "delivery_FK")
    private PersonaEmpleado delivery;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDetalle> detalles;
}
