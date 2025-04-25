package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends BaseEntity {


    @Column(name = "calle", length = 256)
    private String calle;

    @Column(name = "numero", length = 256)
    private int numero;

    @Column(name = "localidad", length = 256)
    private Long localidad;

}
