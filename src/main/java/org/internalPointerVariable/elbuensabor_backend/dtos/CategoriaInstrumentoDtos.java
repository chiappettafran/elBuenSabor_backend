package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;

public abstract class CategoriaInstrumentoDtos {

    @Getter
    @Setter
    public static class ResponseDto {
        private Long id;
        private String denominacion;
    }

    @Getter
    @Setter
    public static class RequestDto {
        private Long id;
        private String denominacion;
    }

}
