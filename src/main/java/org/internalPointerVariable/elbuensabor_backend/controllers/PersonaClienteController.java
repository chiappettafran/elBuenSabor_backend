package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.PersonaClienteDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaCliente;
import org.internalPointerVariable.elbuensabor_backend.services.PersonaClienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/persona_cliente")
public class PersonaClienteController extends BaseController<PersonaCliente, PersonaClienteDtos.ResponseDTO, PersonaClienteDtos.RequestDTO> {

    private final PersonaClienteService service;
    public PersonaClienteController(PersonaClienteService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<PersonaCliente> getEntityClass() {
        return PersonaCliente.class;
    }

    @Override
    protected Class<PersonaClienteDtos.ResponseDTO> getDTOClass() {
        return PersonaClienteDtos.ResponseDTO.class;
    }
}
