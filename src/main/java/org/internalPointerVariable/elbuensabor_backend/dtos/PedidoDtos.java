package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.EstadoPedidoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.StatusMPEnum;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.TipoEnvioEnum;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.List;

public abstract class PedidoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private OffsetDateTime inicioPreparacion;
        private OffsetDateTime finPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private Boolean isAnulado;
        private String mpPreferenceId;
        private StatusMPEnum statusMP;

        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;

        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO {
        private OffsetDateTime inicioPreparacion;
        private OffsetDateTime finPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private Boolean isAnulado;
        private String mpPreferenceId;
        private StatusMPEnum status;
        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;
        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private OffsetDateTime inicioPreparacion;
        private OffsetDateTime finPreparacion;
        private Double total;
        private Double totalCosto;
        private EstadoPedidoEnum estado;
        private TipoEnvioEnum tipoEnvio;
        private FormaPagoEnum formaPago;
        private Boolean isAnulado;
        private String mpPreferenceId;
        private StatusMPEnum status;
        private PersonaClienteDtos.AssignToRelationsDTO cliente;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cajero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO cocinero;
        private PersonaEmpleadoDtos.AssignToRelationsDTO delivery;
        private List<PedidoDetalleDtos.AssignToRelationsDTO> detalles;
    }
}
