package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.UnidadMedidaDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.UnidadMedida;
import org.internalPointerVariable.elbuensabor_backend.repositories.UnidadMedidaRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService extends BaseService<UnidadMedida, UnidadMedidaDtos.ResponseDTO, UnidadMedidaDtos.RequestDTO> {

    private final UnidadMedidaRepository repository;
    public UnidadMedidaService(UnidadMedidaRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
