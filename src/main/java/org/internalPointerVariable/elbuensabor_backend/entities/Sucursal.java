package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.time.LocalTime;

@Entity
@Table(name = "sucursal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sucursal extends BaseEntity {

    @Column(name = "nombre", length = 256)
    private String nombre;

    @Column(name = "horario_apertura", length = 256)
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre", length = 256)
    private LocalTime horarioCierre;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
