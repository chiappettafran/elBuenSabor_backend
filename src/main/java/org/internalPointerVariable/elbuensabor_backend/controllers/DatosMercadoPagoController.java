package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.DatosMercadoPagoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.DatosMercadoPago;
import org.internalPointerVariable.elbuensabor_backend.services.DatosMercadoPagoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/datos_mercado_pago")
public class DatosMercadoPagoController extends BaseController<DatosMercadoPago, DatosMercadoPagoDtos.ResponseDTO, DatosMercadoPagoDtos.RequestDTO> {

    private final DatosMercadoPagoService service;
    public DatosMercadoPagoController(DatosMercadoPagoService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<DatosMercadoPago> getEntityClass() {
        return DatosMercadoPago.class;
    }

    @Override
    protected Class<DatosMercadoPagoDtos.ResponseDTO> getDTOClass() {
        return DatosMercadoPagoDtos.ResponseDTO.class;
    }
}
