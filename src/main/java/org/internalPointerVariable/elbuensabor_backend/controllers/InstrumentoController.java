package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.InstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Instrumento;
import org.internalPointerVariable.elbuensabor_backend.services.InstrumentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrumento")
public class InstrumentoController extends BaseController<Instrumento, InstrumentoDtos.responseDTO, InstrumentoDtos.requestDTO> {

    private final InstrumentoService instrumentoService;
    public InstrumentoController(InstrumentoService instrumentoService) {
        super(instrumentoService);
        this.instrumentoService = instrumentoService;
    }

    @Override
    protected Class<Instrumento> getEntityClass() {
        return Instrumento.class;
    }

    @Override
    protected Class<InstrumentoDtos.responseDTO> getDTOClass() {
        return InstrumentoDtos.responseDTO.class;
    }
}
