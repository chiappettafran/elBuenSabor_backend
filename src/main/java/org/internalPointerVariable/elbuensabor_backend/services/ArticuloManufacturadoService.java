package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloManufacturadoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloManufacturado;
import org.internalPointerVariable.elbuensabor_backend.repositories.ArticuloManufacturadoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, ArticuloManufacturadoDtos.ResponseDTO, ArticuloManufacturadoDtos.RequestDTO> {

    private final ArticuloManufacturadoRepository repository;
    public ArticuloManufacturadoService(ArticuloManufacturadoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
