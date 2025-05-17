package org.internalPointerVariable.elbuensabor_backend.dtos.base;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

public abstract class BaseDtos {

    @Getter
    @Setter
    public abstract static class ResponseDTO {
        private Long id;
        private OffsetDateTime createdAt;
    }

    @Getter
    @Setter
    public abstract static class RequestDTO {

    }

    @Getter
    @Setter
    public abstract static class AssignToRelationsDTO {
        private Long id;
    }
}
