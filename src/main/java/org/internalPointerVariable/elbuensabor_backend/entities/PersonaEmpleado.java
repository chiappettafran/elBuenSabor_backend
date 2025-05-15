package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.PuestoEnum;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaEmpleado extends Persona{

    @Column(name = "puesto", length = 50)
    private PuestoEnum puesto;

}
