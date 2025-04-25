package org.internalPointerVariable.elbuensabor_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instrumento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrumento", length = 256, nullable = false)
    private String instrumento;

    @Column(name = "marca", length = 256, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 256, nullable = false)
    private String modelo;

    @Column(name = "imagen", length = 256)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "costoEnvio", length = 20, nullable = false)
    private String costoEnvio;

    @Column(name = "cantidadVendida", nullable = false)
    private Long cantidadVendida;

    @Column(name = "descripcion", length = 2048, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_fk")
    @JsonIgnoreProperties({"instrumentos"})
    private CategoriaInstrumento categoria;
}
