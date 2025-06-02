package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaCliente extends Persona {

    @Column(name = "dni")
    private Long dni;

    @Column(name = "telefono")
    private Long telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_nacimiento")
    private OffsetDateTime fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "domicilio_fk")
    private Domicilio domicilio;

}
