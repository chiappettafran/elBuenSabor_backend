package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloManufacturadoRubroDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloManufacturadoRubro;
import org.internalPointerVariable.elbuensabor_backend.services.ArticuloManufacturadoRubroService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/articulo_manufacturado_rubro")
public class ArticuloManufacturadoRubroController extends BaseController<ArticuloManufacturadoRubro, ArticuloManufacturadoRubroDtos.ResponseDTO, ArticuloManufacturadoRubroDtos.RequestDTO> {

    private final ArticuloManufacturadoRubroService service;
    public ArticuloManufacturadoRubroController(ArticuloManufacturadoRubroService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<ArticuloManufacturadoRubro> getEntityClass() {
        return ArticuloManufacturadoRubro.class;
    }

    @Override
    protected Class<ArticuloManufacturadoRubroDtos.ResponseDTO> getDTOClass() {
        return ArticuloManufacturadoRubroDtos.ResponseDTO.class;
    }
}
