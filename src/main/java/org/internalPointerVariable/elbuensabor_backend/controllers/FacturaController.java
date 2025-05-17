package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.FacturaDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Factura;
import org.internalPointerVariable.elbuensabor_backend.services.FacturaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/factura")
public class FacturaController extends BaseController<Factura, FacturaDtos.ResponseDTO, FacturaDtos.RequestDTO> {

    private final FacturaService service;
    public FacturaController(FacturaService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<Factura> getEntityClass() {
        return Factura.class;
    }

    @Override
    protected Class<FacturaDtos.ResponseDTO> getDTOClass() {
        return FacturaDtos.ResponseDTO.class;
    }
}
