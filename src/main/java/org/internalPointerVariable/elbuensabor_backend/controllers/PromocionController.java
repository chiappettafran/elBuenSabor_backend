package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.PromocionDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Promocion;
import org.internalPointerVariable.elbuensabor_backend.services.PromocionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/promocion")
public class PromocionController extends BaseController<Promocion, PromocionDtos.ResponseDTO, PromocionDtos.RequestDTO> {

    private final PromocionService service;
    public PromocionController(PromocionService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<Promocion> getEntityClass() {
        return Promocion.class;
    }

    @Override
    protected Class<PromocionDtos.ResponseDTO> getDTOClass() {
        return PromocionDtos.ResponseDTO.class;
    }
}
