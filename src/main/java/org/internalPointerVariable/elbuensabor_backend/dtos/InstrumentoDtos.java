package org.internalPointerVariable.elbuensabor_backend.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public abstract class InstrumentoDtos {

    @Getter
    @Setter
    public static class responseDTO {
        private Long id;
        private String instrumento;
        /*private String marca;
        private String modelo;*/
        private double precio;
    }

    @Getter
    @Setter
    public static class requestDTO {
        private Long id;
        private String instrumento;
        private String marca;
        private String modelo;
        private double precio;
    }
}


