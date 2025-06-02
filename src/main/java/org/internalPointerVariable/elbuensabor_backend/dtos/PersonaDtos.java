package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.RolEnum;

public abstract class PersonaDtos {

    @Getter
    @Setter
    public abstract static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String nombre;
        private String apellido;
        private Long dni;
        private String email;
        private RolEnum rol;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }

    @Getter
    @Setter
    public abstract static class RequestDTO extends BaseDtos.RequestDTO {
        private String nombre;
        private String apellido;
        private Long dni;
        private String email;
        private RolEnum rol;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }

    @Getter
    @Setter
    public abstract static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private String nombre;
        private String apellido;
        private Long dni;
        private RolEnum rol;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }
}
