package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.PedidoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Pedido;
import org.internalPointerVariable.elbuensabor_backend.services.PedidoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class PedidoController extends BaseController<Pedido, PedidoDtos.ResponseDTO, PedidoDtos.RequestDTO> {

    private final PedidoService service;
    public PedidoController(PedidoService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<Pedido> getEntityClass() {
        return Pedido.class;
    }

    @Override
    protected Class<PedidoDtos.ResponseDTO> getDTOClass() {
        return PedidoDtos.ResponseDTO.class;
    }
}

/* ENDPOINTS

GET     localhost:8080/pedido    -> get all
GET     localhost:8080/pedido/id -> get by id
POST    localhost:8080/pedido    -> create
PUT     localhost:8080/pedido/id -> update
DELETE  localhost:8080/pedido/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
    "inicioPreparacion": "2025-05-29T19:43:03.10495-03:00",
    "finPreparacion": "2025-05-29T19:55:03.10495-03:00",
    "total": 5000,
    "totalCosto": 2500,
    "estado": 5,
    "tipoEnvio": 0,
    "formaPago": 1,

    "cliente": {
        "id": 1
    },

    "cajero": {
        "id": 3
    },

    "cocinero": {
        "id": 4
    },

    "delivery": {
        "id": 5
    },

    "detalles": [
        {
            "cantidad": 1,
            "subtotal": 2500,
            "articuloInsumo": {
                "id": 5
            }
        },
        {
            "cantidad": 2,
            "subtotal": 5000,
            "articuloManufacturado": {
                "id": 5
            }
        },
        {
            "cantidad": 1,
            "subtotal": 6000,
            "promocion": {
                "id": 2
            }
        }
    ]
}

*/
