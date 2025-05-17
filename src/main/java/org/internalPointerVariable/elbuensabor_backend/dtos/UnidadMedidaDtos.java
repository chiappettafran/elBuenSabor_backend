package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;

public abstract class UnidadMedidaDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String denominacion;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO {
        private String denominacion;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private String denominacion;
    }
}
