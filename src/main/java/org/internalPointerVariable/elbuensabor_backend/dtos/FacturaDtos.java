package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.FormaPagoEnum;

public abstract class FacturaDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private FormaPagoEnum formaPago;
        private Double totalVenta;
        private Boolean isPagado;
        private DatosMercadoPagoDtos.AssignToRelationsDTO datosMercadoPago;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO {
        private FormaPagoEnum formaPago;
        private Double totalVenta;
        private Boolean isPagado;
        private DatosMercadoPagoDtos.AssignToRelationsDTO datosMercadoPago;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private FormaPagoEnum formaPago;
        private Double totalVenta;
        private Boolean isPagado;
        private DatosMercadoPagoDtos.AssignToRelationsDTO datosMercadoPago;
    }
}
