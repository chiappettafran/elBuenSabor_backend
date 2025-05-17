package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.RolEnum;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends BaseEntity {

    @Column(name = "auth2_id")
    private String auth2Id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "rol")
    private RolEnum rol;
}
