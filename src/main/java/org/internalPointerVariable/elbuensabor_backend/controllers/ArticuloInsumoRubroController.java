package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloInsumoRubroDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloInsumoRubro;
import org.internalPointerVariable.elbuensabor_backend.services.ArticuloInsumoRubroService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/articulo_insumo_rubro")
public class ArticuloInsumoRubroController extends BaseController<ArticuloInsumoRubro, ArticuloInsumoRubroDtos.ResponseDTO, ArticuloInsumoRubroDtos.RequestDTO> {

    private final ArticuloInsumoRubroService service;
    public ArticuloInsumoRubroController(ArticuloInsumoRubroService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<ArticuloInsumoRubro> getEntityClass() {
        return ArticuloInsumoRubro.class;
    }

    @Override
    protected Class<ArticuloInsumoRubroDtos.ResponseDTO> getDTOClass() {
        return ArticuloInsumoRubroDtos.ResponseDTO.class;
    }
}

/* ENDPOINTS

GET     localhost:8080/articulo_insumo_rubro    -> get all
GET     localhost:8080/articulo_insumo_rubro/id -> get by id
POST    localhost:8080/articulo_insumo_rubro    -> create
PUT     localhost:8080/articulo_insumo_rubro/id -> update
DELETE  localhost:8080/articulo_insumo_rubro/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
  "denominacion": "prueba",
  "rubroPadre": { (si estamos creando un rubro padre este atrbuto no va, asi queda null por defecto)
    "id": 1
  }
}

*/
