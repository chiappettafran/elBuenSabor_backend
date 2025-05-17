package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.PersonaEmpleadoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.repositories.PersonaEmpleadoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PersonaEmpleadoService extends BaseService<PersonaEmpleado, PersonaEmpleadoDtos.ResponseDTO, PersonaEmpleadoDtos.RequestDTO> {

    private final PersonaEmpleadoRepository repository;
    public PersonaEmpleadoService(PersonaEmpleadoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
