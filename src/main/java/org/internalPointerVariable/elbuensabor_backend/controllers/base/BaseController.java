package org.internalPointerVariable.elbuensabor_backend.controllers.base;


import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class BaseController<ENTITY extends BaseEntity, RESPONSE_DTO, REQUEST_DTO> {

    private final BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> baseService;
    public BaseController(BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> baseService) {
        this.baseService = baseService;
    }

    @GetMapping()
    public ResponseEntity<List<RESPONSE_DTO>> getAllFiltered(@RequestParam Map<String, String> filters) {
        List<RESPONSE_DTO> dtos = baseService.getAll(filters, getDTOClass());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RESPONSE_DTO> getById(@PathVariable Long id) {
        RESPONSE_DTO dto = baseService.getById(id, getDTOClass());
        return ResponseEntity.ok(dto);
    }

    //post de objetos sin imagen
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //"/"
    public ResponseEntity<RESPONSE_DTO> createJson(@RequestBody REQUEST_DTO dto) {
        RESPONSE_DTO created = baseService.save(dto, getEntityClass(), getDTOClass());
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //post de objetos con imagen
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RESPONSE_DTO> createWithImage(@ModelAttribute REQUEST_DTO dto) {
        RESPONSE_DTO created = baseService.save(dto, getEntityClass(), getDTOClass());
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //put de objetos sin imagen
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RESPONSE_DTO> updateJson(@PathVariable Long id, @RequestBody REQUEST_DTO dto) {
        RESPONSE_DTO updated = baseService.update(id, dto, getEntityClass(), getDTOClass());
        return ResponseEntity.ok(updated);
    }

    //put de objetos con imagen
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RESPONSE_DTO> update(@PathVariable Long id, @ModelAttribute REQUEST_DTO dto) {
        RESPONSE_DTO updated = baseService.update(id, dto, getEntityClass(), getDTOClass());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/hard_delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(baseService.delete(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(baseService.softDelete(id));
    }

    protected abstract Class<ENTITY> getEntityClass();
    protected abstract Class<RESPONSE_DTO> getDTOClass();
}

