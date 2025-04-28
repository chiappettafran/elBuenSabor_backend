package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pais extends BaseEntity {

    @Column(name = "nombre", length = 256)
    private String nombre;

    @OneToMany(mappedBy = "pais",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provincia> provinciasFK;
}
