package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.CategoriaInstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.CategoriaInstrumento;
import org.internalPointerVariable.elbuensabor_backend.services.CategoriaInstrumentoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaInstrumentoController extends BaseController<CategoriaInstrumento, CategoriaInstrumentoDtos.ResponseDto, CategoriaInstrumentoDtos.RequestDto> {

    private final CategoriaInstrumentoService categoriaInstrumentoService;
    public CategoriaInstrumentoController(CategoriaInstrumentoService categoriaInstrumentoService) {
        super(categoriaInstrumentoService);
        this.categoriaInstrumentoService = categoriaInstrumentoService;
    }


    @Override
    protected Class<CategoriaInstrumento> getEntityClass() {
        return CategoriaInstrumento.class;
    }

    @Override
    protected Class<CategoriaInstrumentoDtos.ResponseDto> getDTOClass() {
        return CategoriaInstrumentoDtos.ResponseDto.class;
    }
}
