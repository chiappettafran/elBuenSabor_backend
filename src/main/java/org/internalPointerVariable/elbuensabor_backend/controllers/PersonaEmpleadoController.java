package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.PersonaEmpleadoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.services.PersonaEmpleadoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/persona_empleado")
public class PersonaEmpleadoController extends BaseController<PersonaEmpleado, PersonaEmpleadoDtos.ResponseDTO, PersonaEmpleadoDtos.RequestDTO> {

    private final PersonaEmpleadoService service;
    public PersonaEmpleadoController(PersonaEmpleadoService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<PersonaEmpleado> getEntityClass() {
        return PersonaEmpleado.class;
    }

    @Override
    protected Class<PersonaEmpleadoDtos.ResponseDTO> getDTOClass() {
        return PersonaEmpleadoDtos.ResponseDTO.class;
    }
}
