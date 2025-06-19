package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.EstadoPedidoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.StatusMPEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.TipoEnvioEnum;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class Pedido extends BaseEntity {


    @Column(name = "inicio_preparacion")
    private OffsetDateTime inicioPreparacion;

    @Column(name = "fin_preparacion")
    private OffsetDateTime finPreparacion;

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

    @Column(name = "is_anulado")
    private boolean isAnulado;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "status_MP")
    private StatusMPEnum statusMP;

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
    private List<PedidoDetalle> detalles = new ArrayList<>();;
}
