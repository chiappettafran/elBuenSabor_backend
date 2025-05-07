package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.PuestoEnum;

import java.util.List;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado extends Persona{

    @Column(name = "puesto", length = 50)
    private PuestoEnum puesto;

    @OneToMany(mappedBy = "empleado")
    private List<Pedido> pedidos;
}
