package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "clave", length = 50)
    private String clave;

    @Column(name = "rol", length = 50)
    private String rol;

    @OneToOne
    @JoinColumn (name = "cliente_fk")
    private Cliente cliente;
}
