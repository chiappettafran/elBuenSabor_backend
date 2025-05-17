package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.EstadoPedidoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.TipoEnvioEnum;

import java.time.OffsetTime;
import java.util.List;

public abstract class PedidoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private OffsetTime horaInicioPreparacion;
        private OffsetTime horaFinPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private FacturaDtos.AssignToRelationsDTO factura;
        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;
        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO {
        private OffsetTime horaInicioPreparacion;
        private OffsetTime horaFinPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private FacturaDtos.AssignToRelationsDTO factura;
        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;
        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private OffsetTime horaInicioPreparacion;
        private OffsetTime horaFinPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private FacturaDtos.AssignToRelationsDTO factura;
        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;
        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }
}
