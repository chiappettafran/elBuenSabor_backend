package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public abstract class InstrumentoDtos {

    @Getter
    @Setter
    public static class ResponseDTO {
        private Long id;
        private String instrumento;
        private String marca;
        private String modelo;
        private String imagen;
        private double precio;
        private String costoEnvio;
        private Long cantidadVendida;
        private String descripcion;
        private CategoriaInstrumentoDtos.ResponseDto categoria;
    }

    @Getter
    @Setter
    public static class RequestDTO implements ImageHolderDto {
        private Long id;
        private String instrumento;
        private String marca;
        private String modelo;
        private double precio;
        private String costoEnvio;
        private Long cantidadVendida;
        private String descripcion;
        private Long categoria_fk;

        private String imagen;
        private MultipartFile imagenFile;

        @Override
        public MultipartFile getImagenFile() {
            return imagenFile;
        }

        @Override
        public String getImagen() {
            return imagen;
        }

        @Override
        public void setImagen(String imagen) {
            this.imagen = imagen;
        }
    }
}


