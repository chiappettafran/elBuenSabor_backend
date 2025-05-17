package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.DatosMercadoPagoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.DatosMercadoPago;
import org.internalPointerVariable.elbuensabor_backend.repositories.DatosMercadoPagoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DatosMercadoPagoService extends BaseService<DatosMercadoPago, DatosMercadoPagoDtos.ResponseDTO, DatosMercadoPagoDtos.RequestDTO> {

    private final DatosMercadoPagoRepository repository;
    public DatosMercadoPagoService(DatosMercadoPagoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
