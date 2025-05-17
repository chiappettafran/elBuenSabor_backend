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

/* ENDPOINTS

GET     localhost:8080/articulo_manufacturado_rubro    -> get all
GET     localhost:8080/articulo_manufacturado_rubro/id -> get by id
POST    localhost:8080/articulo_manufacturado_rubro    -> create
PUT     localhost:8080/articulo_manufacturado_rubro/id -> update
DELETE  localhost:8080/articulo_manufacturado_rubro/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
  "denominacion": "panes"
}

*/
