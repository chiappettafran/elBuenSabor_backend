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


/* ENDPOINTS

GET     localhost:8080/articulo_insumo    -> get all
GET     localhost:8080/articulo_insumo/id -> get by id
POST    localhost:8080/articulo_insumo    -> create
PUT     localhost:8080/articulo_insumo/id -> update
DELETE  localhost:8080/articulo_insumo/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
  "denominacion": "Aceite de oliva",
  "descripcion": "Aceite virgen extra importado",
  "precioCompra": 3.00,
  "precioVenta": null, (porque el aceite es un ingrediente y no se va a vender directamente, si es una gaseosa si tendria precio)
  "esParaElaborar": true,
  "stock": 1450,

  "unidadMedida": {
    "id": 5
  },

  "articuloInsumoRubro": {
    "id": 17
  }
}

con este JSON en una prueba en postman el atributo imagen va a quedar como null porque tiene que ir com
multipart. En ImageHolderDto hay un ejemplo de cómo tiene que ser un post con una imagen desde el front.
Tambien usar el tp de instrumentos como ejemplo.
Esto es para que se guarde la imagen en el repositorio del back, si quieren que lo hagamos con urls
siempre tambien podemos, lo hablamos.

*/
