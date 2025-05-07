package org.internalPointerVariable.elbuensabor_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente extends Persona {

    @Column(name = "fecha_nacimiento", length = 256)
    private LocalDate fechaNacimiento;

    @OneToOne
    @JoinColumn (name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    @ManyToMany
    @JoinTable(
            name = "cliente_domicilio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id")
    )
    private List<Domicilio> domicilioFK;

    @OneToOne
    @JoinColumn (name = "usuario_fk")
    private Usuario usuarioFK;

}
