package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.StatusMPEnum;

import java.time.LocalDate;

@Entity
@Table(name = "datos_mercado_pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class DatosMercadoPago extends BaseEntity {

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "status")
    private StatusMPEnum status;
    
}
