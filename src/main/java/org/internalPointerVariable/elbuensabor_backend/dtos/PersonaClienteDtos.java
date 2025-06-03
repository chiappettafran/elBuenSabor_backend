package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

public abstract class PersonaClienteDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends PersonaDtos.ResponseDTO {
        private Long dni;
        private Long telefono;
        private OffsetDateTime fechaNacimiento;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }

    @Getter
    @Setter
    public static class RequestDTO extends PersonaDtos.RequestDTO {
        private Long dni;
        private Long telefono;
        private OffsetDateTime fechaNacimiento;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends PersonaDtos.AssignToRelationsDTO {
        private Long dni;
        private Long telefono;
        private OffsetDateTime fechaNacimiento;
        private DomicilioDtos.AssignToRelationsDTO domicilio;
    }
}
