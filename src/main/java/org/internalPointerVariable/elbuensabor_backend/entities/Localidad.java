package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "localidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Localidad extends BaseEntity {

    @Column(name = "nombre", length = 256)
    private String nombre;

    @OneToMany(mappedBy = "localidad",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domicilio> domiciliosFK;

}
