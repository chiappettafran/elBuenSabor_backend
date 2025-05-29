package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.springframework.web.multipart.MultipartFile;

public abstract class ArticuloInsumoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String denominacion;
        private String descripcion;
        private Double precioCompra;
        private Double precioVenta;
        private String imagen;
        private Boolean esParaElaborar;
        private Double stock;
        private Double stockMinimo;
        private ArticuloInsumoRubroDtos.AssignToRelationsDTO articuloInsumoRubro;
        private UnidadMedidaDtos.AssignToRelationsDTO unidadMedida;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO implements ImageHolderDto {
        private String denominacion;
        private String descripcion;
        private Double precioCompra;
        private Double precioVenta;
        private Boolean esParaElaborar;
        private Double stock;
        private Double stockMinimo;
        private ArticuloInsumoRubroDtos.AssignToRelationsDTO articuloInsumoRubro;
        private UnidadMedidaDtos.AssignToRelationsDTO unidadMedida;

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
        private Boolean esParaElaborar;
        private String imagen;
        private Double stock;
        private Double stockMinimo;
        private ArticuloInsumoRubroDtos.AssignToRelationsDTO articuloInsumoRubro;
        private UnidadMedidaDtos.AssignToRelationsDTO unidadMedida;
    }
}
