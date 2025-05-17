package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloInsumoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloInsumo;
import org.internalPointerVariable.elbuensabor_backend.services.ArticuloInsumoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/articulo_insumo")
public class ArticuloInsumoController extends BaseController<ArticuloInsumo, ArticuloInsumoDtos.ResponseDTO, ArticuloInsumoDtos.RequestDTO> {

    private final ArticuloInsumoService service;
    public ArticuloInsumoController(ArticuloInsumoService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<ArticuloInsumo> getEntityClass() {
        return ArticuloInsumo.class;
    }

    @Override
    protected Class<ArticuloInsumoDtos.ResponseDTO> getDTOClass() {
        return ArticuloInsumoDtos.ResponseDTO.class;
    }
}
