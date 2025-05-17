package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;

public abstract class PedidoDetalleDtos {

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private Integer cantidad;
        private Double subtotal;

        //va a entrar uno solo de estos tres
        private ArticuloInsumoDtos.AssignToRelationsDTO articuloInsumo;
        private ArticuloManufacturadoDtos.AssignToRelationsDTO articuloManufacturado;
        private PromocionDtos.AssignToRelationsDTO promocion;
    }
}
