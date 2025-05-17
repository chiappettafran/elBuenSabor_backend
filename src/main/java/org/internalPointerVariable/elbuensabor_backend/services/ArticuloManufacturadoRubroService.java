package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloManufacturadoRubroDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloManufacturadoRubro;
import org.internalPointerVariable.elbuensabor_backend.repositories.ArticuloManufacturadoRubroRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoRubroService extends BaseService<ArticuloManufacturadoRubro, ArticuloManufacturadoRubroDtos.ResponseDTO, ArticuloManufacturadoRubroDtos.RequestDTO> {

    private final ArticuloManufacturadoRubroRepository repository;
    public ArticuloManufacturadoRubroService(ArticuloManufacturadoRubroRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
