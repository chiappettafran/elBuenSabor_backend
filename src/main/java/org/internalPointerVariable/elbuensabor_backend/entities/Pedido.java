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

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends BaseEntity {


    @Column(name = "hora_estimada_finalizacion", length = 256)
    private LocalTime horaEstamadaFinalizacion;

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
}
