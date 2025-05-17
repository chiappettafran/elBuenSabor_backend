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

/* ENDPOINTS

GET     localhost:8080/articulo_manufacturado    -> get all
GET     localhost:8080/articulo_manufacturado/id -> get by id
POST    localhost:8080/articulo_manufacturado    -> create
PUT     localhost:8080/articulo_manufacturado/id -> update
DELETE  localhost:8080/articulo_manufacturado/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
    "denominacion": "Pan random de aceite de oliva y harina 000",
    "descripcion": "Este es un pan de prueba, no lo intenten en sus casas",
    "precioCompra": 20.5,
    "precioVenta": 25.5,
    "tiempoEstimado": 20,

    "articuloManufacturadoRubro": {
        "id": 1
    },

    "detalles": [
        {
            "cantidad": 500,
            "articuloInsumo": { puede viajar el objeto completo o solo el id, como es de asignacion para el dto es indistinto
                "id": 1
            }
        },

        {
            "cantidad": 1.5,
            "articuloInsumo": {
                "id": 2
            }
        }
    ]
}

con este JSON en una prueba en postman el atributo imagen va a quedar como null porque tiene que ir com
multipart. En ImageHolderDto hay un ejemplo de cómo tiene que ser un post con una imagen desde el front.
Tambien usar el tp de instrumentos como ejemplo.
Esto es para que se guarde la imagen en el repositorio del back, si quieren que lo hagamos con urls
siempre tambien podemos, lo hablamos.

*/
