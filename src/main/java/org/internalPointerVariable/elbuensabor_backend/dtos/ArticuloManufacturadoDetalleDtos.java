package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;

public abstract class   ArticuloManufacturadoDetalleDtos {

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private Double cantidad;
        private ArticuloInsumoDtos.AssignToRelationsDTO articuloInsumo;
    }
}
