package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.ArticuloInsumoRubroDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.ArticuloInsumoRubro;
import org.internalPointerVariable.elbuensabor_backend.repositories.ArticuloInsumoRubroRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoRubroService extends BaseService<ArticuloInsumoRubro, ArticuloInsumoRubroDtos.ResponseDTO, ArticuloInsumoRubroDtos.RequestDTO> {

    private final ArticuloInsumoRubroRepository repository;
    public ArticuloInsumoRubroService(ArticuloInsumoRubroRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
