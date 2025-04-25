package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.CategoriaInstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.CategoriaInstrumento;
import org.internalPointerVariable.elbuensabor_backend.repositories.CategoriaInstrumentoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaInstrumentoService extends BaseService<CategoriaInstrumento, CategoriaInstrumentoDtos.ResponseDto, CategoriaInstrumentoDtos.RequestDto> {

    private final CategoriaInstrumentoRepository categoriaInstrumentoRepository;
    public CategoriaInstrumentoService(CategoriaInstrumentoRepository categoriaInstrumentoRepository) {
        super(categoriaInstrumentoRepository);
        this.categoriaInstrumentoRepository = categoriaInstrumentoRepository;
    }
}
