package org.internalPointerVariable.elbuensabor_backend.services;

import jakarta.persistence.EntityNotFoundException;
import org.internalPointerVariable.elbuensabor_backend.dtos.CategoriaInstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.dtos.InstrumentoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.CategoriaInstrumento;
import org.internalPointerVariable.elbuensabor_backend.entities.Instrumento;
import org.internalPointerVariable.elbuensabor_backend.repositories.CategoriaInstrumentoRepository;
import org.internalPointerVariable.elbuensabor_backend.repositories.InstrumentoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoService extends BaseService<Instrumento, InstrumentoDtos.ResponseDTO, InstrumentoDtos.RequestDTO> {

    private final InstrumentoRepository instrumentoRepository;
    public InstrumentoService(InstrumentoRepository instrumentoRepository, CategoriaInstrumentoService categoriaInstrumentoService) {
        super(instrumentoRepository);
        this.instrumentoRepository = instrumentoRepository;
    }

    @Autowired
    private CategoriaInstrumentoRepository categoriaInstrumentoRepository;

    @Override
    protected void processEntityRelationshipsWrite(Instrumento entity, InstrumentoDtos.RequestDTO dto) {
        if (dto.getCategoria_fk() != null) {
            CategoriaInstrumento categoriaInstrumento = categoriaInstrumentoRepository.findById(dto.getCategoria_fk())
                    .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
            entity.setCategoria(categoriaInstrumento);
        }
    }

    @Override
    protected InstrumentoDtos.ResponseDTO processEntityRelationshipsRead(Instrumento entity, InstrumentoDtos.ResponseDTO dto) {
        if (entity.getCategoria() != null) {
            dto.setCategoria(modelMapper.map(entity.getCategoria(), CategoriaInstrumentoDtos.ResponseDto.class));
            return dto;
        } else {
            throw new EntityNotFoundException("Categoria no encontrada");
        }
    }
}
