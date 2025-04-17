package org.internalPointerVariable.elbuensabor_backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public abstract class BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> {

    private final JpaRepository<ENTITY, Long> entityRepository;
    public BaseService(JpaRepository<ENTITY, Long> entityRepository) {
        this.entityRepository = entityRepository;
    }

    protected ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public List<RESPONSE_DTO> getAll(Class<RESPONSE_DTO> dtoClass) {
        return entityRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RESPONSE_DTO getById(Long id, Class<RESPONSE_DTO> dtoClass) {
        ENTITY entity = entityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entidad con ID " + id + " no encontrada"));
        return modelMapper.map(entity, dtoClass);
    }

    @Transactional
    public ENTITY save(REQUEST_DTO dto, Class<ENTITY> entityClass) {
        ENTITY entity = modelMapper.map(dto, entityClass);
        return entityRepository.save(entity);
    }

    @Transactional
    public ENTITY update(Long id, REQUEST_DTO dto, Class<ENTITY> entityClass) {
        ENTITY existing = entityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entidad con ID " + id + " no encontrada"));
        ENTITY updated = modelMapper.map(dto, entityClass);
        BeanUtils.copyProperties(updated, existing, "id");
        return entityRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        if (!entityRepository.existsById(id)) {
            throw new NoSuchElementException("Entidad con ID " + id + " no encontrada");
        }
        entityRepository.deleteById(id);
    }
}
