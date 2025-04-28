package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

@Entity
@Table(name = "imagen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Imagen extends BaseEntity {


    @Column(name = "denominacion", length = 256)
    private String denominacion;

    @OneToOne
    @JoinColumn(name = "cliente_fk")
    private Cliente cliente;
}
