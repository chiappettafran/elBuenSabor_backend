package org.internalPointerVariable.elbuensabor_backend.entities.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion", length = 256)
    private LocalDate fechaCreacion;

    @Column(name = "esta_eliminado", length = 256)
    private boolean estaEliminado;


}
