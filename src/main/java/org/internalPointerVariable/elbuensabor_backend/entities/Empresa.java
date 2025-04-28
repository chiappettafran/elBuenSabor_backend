package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "empresa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empresa extends BaseEntity {

    @Column(name = "nombre", length = 256)
    private String nombre;

    @Column(name = "razon_social", length = 256)
    private String razonSocial;

    @Column(name = "cuil", length = 256)
    private Integer Cuil;

    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empresa> empresasFK;
}
