package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_instrumento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaInstrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion", length = 256, nullable = false)
    private String denominacion;

    @OneToMany(mappedBy = "categoria")
    private List<Instrumento> instrumentos = new ArrayList<>();
}