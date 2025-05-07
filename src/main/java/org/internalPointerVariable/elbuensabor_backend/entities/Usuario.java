package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.RolEnum;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Persona{

    @Column(name = "auth0_id", length = 50)
    private String auth0Id;

    @Column(name = "username", length = 50)
    private String usuario;

    @Column(name = "foto_perfil", length = 50)
    private String fotoPerfil;

    @Column(name = "rol", length = 50)
    private RolEnum rol;

    @OneToOne
    @JoinColumn (name = "cliente_fk")
    private Cliente cliente;
}
