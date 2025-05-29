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

/* ENDPOINTS

GET     localhost:8080/promocion    -> get all
GET     localhost:8080/promocion/id -> get by id
POST    localhost:8080/promocion    -> create
PUT     localhost:8080/promocion/id -> update
DELETE  localhost:8080/promocion/id -> soft delete

EJEMPLO DE JSON PARA POST y PUT (en el put no puede faltar ningun atributo si no actualizara a null)

{
    "denominacion": "25% off pizza comun + quilmes 960cc",
    "fechaDesde": "2025-01-01T00:00:00-03:00", --importante este formato para la fecha y hora, si no no la va a tomar el spring y va a explotar PUMMMM
    "fechaHasta": "2025-12-31T00:00:00-03:00", --el -03:00 es lo especial (zona horaria arg papa, mate asado don satur y fernet)
    "descuento": 0.25,
    "detalles": [
        {
            "cantidad": 1,
            "articuloInsumo": {
                "id": 5
            }
        },
        {
            "cantidad": 1,
            "articuloManufacturado": {
                "id": 7
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

