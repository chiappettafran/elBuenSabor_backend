package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.PuestoEnum;

public abstract class PersonaEmpleadoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends PersonaDtos.ResponseDTO {
        private PuestoEnum puesto;
    }

    @Getter
    @Setter
    public static class RequestDTO extends PersonaDtos.RequestDTO {
        private PuestoEnum puesto;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends PersonaDtos.AssignToRelationsDTO {
        private PuestoEnum puesto;
    }
}
