package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.EstadoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.TipoEnvioEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends BaseEntity {

    @Column(name = "hora_inicio_preparacion", length = 256)
    private LocalTime horaInicioPreparacion;

    @Column(name = "hora_fin_preparacion", length = 256)
    private LocalTime horaFinPreparacion;

    @Column(name = "total", length = 256)
    private Double total;

    @Column(name = "total_costo", length = 256)
    private Double totalCosto;

    @Column(name = "estado", length = 256)
    private EstadoEnum estado;

    @Column(name = "tipo_envio", length = 256)
    private TipoEnvioEnum tipoEnvio;

    @Column(name = "forma_pago", length = 256)
    private FormaPagoEnum formaPago;

    @Column(name = "fecha_pedido", length = 256)
    private LocalDate fechaPedido; //Este aparece en el uml pero creo que se puede exceptuar ya que esta en en BaseEntity

    @ManyToOne
    @JoinColumn(name = "cliente_fk")
    private Cliente clienteFK;

    @ManyToOne
    @JoinColumn(name = "domicilio_fk")
    private Domicilio domicilioFK;

    @ManyToOne
    @JoinColumn(name = "cajero_fk")
    private Empleado cajeroFK;

    @ManyToOne
    @JoinColumn(name = "cocinero_fk")
    private Empleado cocineroFK;

    @ManyToOne
    @JoinColumn(name = "delivery_FK")
    private Empleado deliveryFK;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallesFK;

}
