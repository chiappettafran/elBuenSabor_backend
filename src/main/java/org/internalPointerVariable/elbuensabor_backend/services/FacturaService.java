package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.FacturaDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Factura;
import org.internalPointerVariable.elbuensabor_backend.repositories.FacturaRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class FacturaService extends BaseService<Factura, FacturaDtos.ResponseDTO, FacturaDtos.RequestDTO> {

    private final FacturaRepository repository;
    public FacturaService(FacturaRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
