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
