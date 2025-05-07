package org.internalPointerVariable.elbuensabor_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona extends BaseEntity {

    protected String nombre;

    protected String apellido;

    protected Integer dni;

    protected Integer telefono;

    protected String email;


}
