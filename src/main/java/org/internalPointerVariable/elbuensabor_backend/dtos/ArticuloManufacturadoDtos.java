package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public abstract class ArticuloManufacturadoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String denominacion;
        private String descripcion;
        private Double precioCompra;
        private Double precioVenta;
        private String imagen;
        private Integer tiempoEstimado;
        private ArticuloManufacturadoRubroDtos.AssignToRelationsDTO articuloManufacturadoRubro;
        private List<ArticuloManufacturadoDetalleDtos.AssignToRelationsDTO> detalles;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO implements ImageHolderDto {
        private String denominacion;
        private String descripcion;
        private Double precioCompra;
        private Double precioVenta;
        private Integer tiempoEstimado;
        private ArticuloManufacturadoRubroDtos.AssignToRelationsDTO articuloManufacturadoRubro;
        private List<ArticuloManufacturadoDetalleDtos.AssignToRelationsDTO> detalles;

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
        private Double precioCompra;
        private Double precioVenta;
        private String imagen;
        private Integer tiempoEstimado;
        private ArticuloManufacturadoRubroDtos.AssignToRelationsDTO articuloManufacturadoRubro;
        private List<ArticuloManufacturadoDetalleDtos.AssignToRelationsDTO> detalles;
    }
}
