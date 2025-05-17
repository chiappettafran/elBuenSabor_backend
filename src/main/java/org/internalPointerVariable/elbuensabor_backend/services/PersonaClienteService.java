package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.PersonaClienteDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaCliente;
import org.internalPointerVariable.elbuensabor_backend.repositories.PersonaClienteRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PersonaClienteService extends BaseService<PersonaCliente, PersonaClienteDtos.ResponseDTO, PersonaClienteDtos.RequestDTO> {

    private final PersonaClienteRepository repository;
    public PersonaClienteService(PersonaClienteRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
