package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.RolEnum;
import org.springframework.web.multipart.MultipartFile;

public abstract class UsuarioDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String auth2Id;
        private String usuario;
        private String fotoPerfil;
        private RolEnum rol;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO implements ImageHolderDto {
        private String auth2Id;
        private String usuario;
        private RolEnum rol;

        private String fotoPerfil;
        private MultipartFile imagenFile;

        @Override
        public MultipartFile getImagenFile() {
            return imagenFile;
        }

        @Override
        public String getImagen() {
            return fotoPerfil;
        }

        @Override
        public void setImagen(String imagen) {
            this.fotoPerfil = imagen;
        }
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private String auth2Id;
        private String usuario;
        private String fotoPerfil;
        private RolEnum rol;
    }

}
