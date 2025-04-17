package org.internalPointerVariable.elbuensabor_backend.controllers.base;

import org.internalPointerVariable.elbuensabor_backend.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<ENTITY, RESPONSE_DTO, REQUEST_DTO> {

    private final BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> baseService;
    public BaseController(BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("")
    public ResponseEntity<List<RESPONSE_DTO>> getAll() {
        List<RESPONSE_DTO> dtos = baseService.getAll(getDTOClass());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RESPONSE_DTO> getById(@PathVariable Long id) {
        RESPONSE_DTO dto = baseService.getById(id, getDTOClass());
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<ENTITY> create(@RequestBody REQUEST_DTO dto) {
        ENTITY created = baseService.save(dto, getEntityClass());
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ENTITY> update(@PathVariable Long id, @RequestBody REQUEST_DTO dto) {
        ENTITY updated = baseService.update(id, dto, getEntityClass());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        baseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    protected abstract Class<ENTITY> getEntityClass();
    protected abstract Class<RESPONSE_DTO> getDTOClass();
}
