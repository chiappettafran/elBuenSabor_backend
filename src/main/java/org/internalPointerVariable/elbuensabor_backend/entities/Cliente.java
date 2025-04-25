package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imagen", length = 256)
    private String nombre;

    @Column(name = "imagen", length = 256)
    private String apellido;

    @Column(name = "imagen", length = 256)
    private Long telefono;

    @Column(name = "imagen", length = 256)
    private String email;

}
