package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "provincia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Provincia extends BaseEntity {

    @Column(name = "nombre", length = 256)
    private String nombre;

    @OneToMany(mappedBy = "provincia",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provincia> provincias;
}
