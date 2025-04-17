package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.InstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Instrumento;
import org.internalPointerVariable.elbuensabor_backend.repositories.InstrumentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoService extends BaseService<Instrumento, InstrumentoDtos.responseDTO, InstrumentoDtos.requestDTO> {

    private InstrumentoRepository instrumentoRepository;
    public InstrumentoService(InstrumentoRepository instrumentoRepository) {
        super(instrumentoRepository);
        this.instrumentoRepository = instrumentoRepository;
    }
}
