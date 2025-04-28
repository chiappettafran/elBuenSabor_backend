package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends BaseEntity {


    @Column(name = "calle", length = 256)
    private String calle;

    @Column(name = "numero", length = 256)
    private int numero;

    @Column(name = "cp", length = 256)
    private Integer cp;

    @OneToMany(mappedBy = "domicilio_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidosFK;

    @ManyToMany(mappedBy = "domicilios")
    private List<Cliente> clientesFK;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
}
