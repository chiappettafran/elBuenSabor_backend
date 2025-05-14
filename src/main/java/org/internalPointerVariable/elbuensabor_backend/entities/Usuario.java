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

    @Column(name = "auth2_id")
    private String auth2Id;

    @Column(name = "username", length = 80)
    private String usuario;

    @Column(name = "foto_perfil", length = 80)
    private String fotoPerfil;

    @Column(name = "rol", length = 50)
    private RolEnum rol;
}
