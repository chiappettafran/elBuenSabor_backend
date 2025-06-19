package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

public abstract class PromocionDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String denominacion;
        private String descripcion;
        private OffsetDateTime fechaDesde;
        private OffsetDateTime fechaHasta;
        private Double precioVenta;
        private String imagen;
        private Double descuento;
        private List<PromocionDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO implements ImageHolderDto {
        private String denominacion;
        private String descripcion;
        private OffsetDateTime fechaDesde;
        private OffsetDateTime fechaHasta;
        private Double precioVenta;
        private Double descuento;
        private List<PromocionDetalleDtos.AssignToRelationsDTO> detalles;

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

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private String denominacion;
        private String descripcion;
        private OffsetDateTime fechaDesde;
        private OffsetDateTime fechaHasta;
        private Double precioVenta;
        private String imagen;
        private Double descuento;
        private List<PromocionDetalleDtos.AssignToRelationsDTO> detalles;
    }
}
