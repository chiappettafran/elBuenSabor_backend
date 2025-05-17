package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloManufacturadoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloManufacturado;
import org.internalPointerVariable.elbuensabor_backend.services.ArticuloManufacturadoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/articulo_manufacturado")
public class ArticuloManufacturadoController extends BaseController<ArticuloManufacturado, ArticuloManufacturadoDtos.ResponseDTO, ArticuloManufacturadoDtos.RequestDTO> {

    private final ArticuloManufacturadoService service;
    public ArticuloManufacturadoController(ArticuloManufacturadoService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<ArticuloManufacturado> getEntityClass() {
        return ArticuloManufacturado.class;
    }

    @Override
    protected Class<ArticuloManufacturadoDtos.ResponseDTO> getDTOClass() {
        return ArticuloManufacturadoDtos.ResponseDTO.class;
    }
}
