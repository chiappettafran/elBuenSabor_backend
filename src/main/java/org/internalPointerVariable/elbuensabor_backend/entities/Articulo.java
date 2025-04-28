package org.internalPointerVariable.elbuensabor_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Articulo {

    protected String denominacion;

    protected Double precioVenta;
}
