package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.UnidadMedidaDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.UnidadMedida;
import org.internalPointerVariable.elbuensabor_backend.services.UnidadMedidaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/unidad_medida")
public class UnidadMedidaController extends BaseController<UnidadMedida, UnidadMedidaDtos.ResponseDTO, UnidadMedidaDtos.RequestDTO> {

    private final UnidadMedidaService service;
    public UnidadMedidaController(UnidadMedidaService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<UnidadMedida> getEntityClass() {
        return UnidadMedida.class;
    }

    @Override
    protected Class<UnidadMedidaDtos.ResponseDTO> getDTOClass() {
        return UnidadMedidaDtos.ResponseDTO.class;
    }
}

/* ENDPOINTS

GET     localhost:8080/unidad_medida    -> get all
GET     localhost:8080/unidad_medida/id -> get by id
POST    localhost:8080/unidad_medida    -> create
PUT     localhost:8080/unidad_medida/id -> update
DELETE  localhost:8080/unidad_medida/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
  "denominacion": "prueba"
}

*/


