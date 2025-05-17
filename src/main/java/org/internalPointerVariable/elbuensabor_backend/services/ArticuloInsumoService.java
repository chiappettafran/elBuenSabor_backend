package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloInsumoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloInsumo;
import org.internalPointerVariable.elbuensabor_backend.repositories.ArticuloInsumoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo, ArticuloInsumoDtos.ResponseDTO, ArticuloInsumoDtos.RequestDTO> {

    private final ArticuloInsumoRepository repository;
    public ArticuloInsumoService(ArticuloInsumoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
