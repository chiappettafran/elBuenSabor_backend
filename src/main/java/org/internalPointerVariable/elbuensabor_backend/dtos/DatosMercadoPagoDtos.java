package org.internalPointerVariable.elbuensabor_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.dtos.base.BaseDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.StatusMPEnum;

public abstract class DatosMercadoPagoDtos {

    @Getter
    @Setter
    public static class ResponseDTO extends BaseDtos.ResponseDTO {
        private String mpPreferenceId;
        private StatusMPEnum status;
    }

    @Getter
    @Setter
    public static class RequestDTO extends BaseDtos.RequestDTO {
        private String mpPreferenceId;
        private StatusMPEnum status;
    }

    @Getter
    @Setter
    public static class AssignToRelationsDTO extends BaseDtos.AssignToRelationsDTO {
        private String mpPreferenceId;
        private StatusMPEnum status;
    }
}
