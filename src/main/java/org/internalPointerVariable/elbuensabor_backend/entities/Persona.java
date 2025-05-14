package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Persona extends BaseEntity {

    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "apellido", length = 80)
    private String apellido;

    @Column(name = "dni")
    private Long dni;

    @Column(name = "telefono")
    private Long telefono;

    @Column(name = "apellido", length = 150)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "domicilio_fk")
    private Domicilio domicilio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

}
