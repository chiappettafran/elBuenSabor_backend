package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;

public abstract class PromocionDetalleDtos {

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private Integer cantidad;

        //va a entrar uno solo de estos dos
        private ArticuloInsumoDtos.AssignToRelationsDTO articuloInsumo;
        private ArticuloManufacturadoDtos.AssignToRelationsDTO articuloManufacturado;
    }
}
