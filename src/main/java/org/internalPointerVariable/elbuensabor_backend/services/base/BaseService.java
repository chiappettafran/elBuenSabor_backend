package org.internalPointerVariable.elbuensabor_backend.services.base;

import jakarta.persistence.criteria.Predicate;
import org.internalPointerVariable.elbuensabor_backend.dtos.ImageHolderDto;
import org.internalPointerVariable.elbuensabor_backend.entities.base.BaseEntity;
import org.internalPointerVariable.elbuensabor_backend.exceptions.ImageProcessingException;
import org.internalPointerVariable.elbuensabor_backend.repositories.base.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseService<ENTITY extends BaseEntity, RESPONSE_DTO, REQUEST_DTO> {

    private final BaseRepository<ENTITY> entityRepository;
    public BaseService(BaseRepository<ENTITY> entityRepository) {
        this.entityRepository = entityRepository;
    }
    private final String UPLOAD_DIR = "uploads/";
    protected final ModelMapper modelMapper = new ModelMapper();


    //esto funciona con filtros, en cada controlador voy a ir especificando cuales y como funcionan por entidad,
    //igual los mas importantes son los de los productos y pedidos por fecha
    @Transactional(readOnly = true)
    public List<RESPONSE_DTO> getAll(Map<String, String> filters, Class<RESPONSE_DTO> dtoClass) {
        Specification<ENTITY> spec = buildSpecificationFromFilters(filters);
        return entityRepository.findAll(spec).stream()
                .map(entity -> processEntityRelationshipsRead(entity, modelMapper.map(entity, dtoClass)))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RESPONSE_DTO getById(Long id, Class<RESPONSE_DTO> dtoClass) {
        ENTITY entity = entityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entidad con ID " + id + " no encontrada"));
        return processEntityRelationshipsRead(entity, modelMapper.map(entity, dtoClass));
    }

    @Transactional
    public RESPONSE_DTO save(REQUEST_DTO dto, Class<ENTITY> entityClass, Class<RESPONSE_DTO> responseDtoClass) {
        ENTITY entity = modelMapper.map(dto, entityClass);

        //si el dto de entrada esta marcado como portador de imagen la busca y la guarda, si no aca no paso nada y nos re vimo
        if (dto instanceof ImageHolderDto imageHolderDto && imageHolderDto.getImagenFile() != null && !imageHolderDto.getImagenFile().isEmpty()) {
            String imagen = saveImage(imageHolderDto.getImagenFile());
            imageHolderDto.setImagen(imagen);
            entity = modelMapper.map(dto, entityClass);
        }

        processEntityRelationshipsWrite(entity, dto);
        entity.setCreatedAt(OffsetDateTime.now());
        return processEntityRelationshipsRead(entity, modelMapper.map(entityRepository.save(entity), responseDtoClass));
    }

    @Transactional
    public RESPONSE_DTO update(Long id, REQUEST_DTO dto, Class<ENTITY> entityClass, Class<RESPONSE_DTO> responseDtoClass) {
        ENTITY existing = entityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entidad con ID " + id + " no encontrada"));


        if (dto instanceof ImageHolderDto imageHolderDto) {
            MultipartFile newImagenFile = imageHolderDto.getImagenFile();
            if (newImagenFile != null && !newImagenFile.isEmpty()) {
                if (imageHolderDto.getImagen() != null) {
                    deleteImage(imageHolderDto.getImagen());
                }
                String imagen = saveImage(newImagenFile);
                imageHolderDto.setImagen(imagen);
            }
        }

        ENTITY updated = modelMapper.map(dto, entityClass);
        updated.setCreatedAt(existing.getCreatedAt());
        processEntityRelationshipsUpdate(existing, updated);
        BeanUtils.copyProperties(updated, existing, getIgnorePropertiesArray());

        return processEntityRelationshipsRead(existing, modelMapper.map(entityRepository.save(existing), responseDtoClass));
    }

    //delete full full irrecuperable insalvable no papelera de reciclaje
    @Transactional
    public boolean delete(Long id) {
        if (!entityRepository.existsById(id)) {
            throw new NoSuchElementException("Entidad con ID " + id + " no encontrada");
        }
        entityRepository.deleteById(id);
        return true;
    }

    //delete con OSDE
    @Transactional
    public boolean softDelete(Long id) {
        Optional<ENTITY> optionalEntity = entityRepository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new NoSuchElementException("Entidad con ID " + id + " no encontrada");
        }

        ENTITY entity = optionalEntity.get();
        entity.setIsDeleted(true);
        entity.setDeletedAt(OffsetDateTime.now());
        entityRepository.save(entity);
        return true;
    }

    protected void processEntityRelationshipsWrite(ENTITY entity, REQUEST_DTO dto) {
    }
    //cada servicio especifico puede sobreescribir estos métodos si queremos procesar sus relaciones a parte,
    //segun mis pruebas el Read no es tan necesario si estan bien mapeados los dtos, pero el Write y update sí lo es
    //ya que ahi realizamos las asignaciones pertinentes :) mucho texto pero me pidieron comentar y esto es
    //lo que me sale salu2 que tengan un buen dia/tardes/noches/contranoches!!!
    protected void processEntityRelationshipsUpdate(ENTITY existing, ENTITY updated) {}
    protected RESPONSE_DTO processEntityRelationshipsRead(ENTITY entity, RESPONSE_DTO dto) {
        return dto;
    }
    protected String[] getIgnorePropertiesArray() {
        return new String[]{"id"};
    }


    //para guardar la imagen en la carpeta correspondiente cuando se guarda/updatea la entidad
    private String saveImage(MultipartFile imagen) {
        try {
            Path dirPath = Paths.get(UPLOAD_DIR);

            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            String originalFilename = imagen.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + fileExtension;

            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.write(filePath, imagen.getBytes());

            return fileName;
        } catch (IOException e) {
            throw new ImageProcessingException("Error al guardar la imagen", e);
        }
    }

    //el update invoca este metodo para eliminar la imagen existente de una entidad cuando la reemplace
    //por una nueva
    private void deleteImage(String imagen) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR + imagen);
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
        } catch (IOException e) {
            throw new ImageProcessingException("No se pudo eliminar la imagen: " + imagen, e);
        }
    }

    //para filtros, no se como ni por que pero tambien funciona (o por lo menos funcionaba con los instrumentos)
    @SuppressWarnings("unchecked")
    private Specification<ENTITY> buildSpecificationFromFilters(Map<String, String> filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            ZoneId argentinaZone = ZoneId.of("America/Argentina/Buenos_Aires");

            filters.forEach((field, value) -> {
                if (value == null || value.isBlank()) return;

                try {
                    if (field.endsWith("Desde") || field.endsWith("Hasta")) {
                        String potentialBaseField = field.substring(0, field.length() - 5);

                        try {
                            Field baseFieldCheck = root.getJavaType().getDeclaredField(potentialBaseField);
                            Class<?> fieldType = baseFieldCheck.getType();

                            if (fieldType == OffsetDateTime.class || fieldType == LocalDateTime.class
                                    || fieldType == Date.class || fieldType == LocalDate.class) {
                                OffsetDateTime parsedDate = parseDateWithTimeZone(value, argentinaZone);
                                if (parsedDate != null) {

                                    if (field.endsWith("Hasta")) {
                                        parsedDate = parsedDate.with(LocalTime.MAX);
                                    }

                                    if (field.endsWith("Desde")) {
                                        predicates.add(cb.greaterThanOrEqualTo(root.get(potentialBaseField), parsedDate));
                                    } else {
                                        predicates.add(cb.lessThanOrEqualTo(root.get(potentialBaseField), parsedDate));
                                    }
                                }
                                return;
                            }
                        } catch (NoSuchFieldException ignored) {

                        }
                    }

                    Field declaredField = root.getJavaType().getDeclaredField(field);
                    Class<?> fieldType = declaredField.getType();

                    if (fieldType == String.class) {
                        predicates.add(cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%"));
                    }

                    else if (fieldType == Integer.class || fieldType == int.class) {
                        predicates.add(cb.equal(root.get(field), Integer.parseInt(value)));
                    }
                    else if (fieldType == Long.class || fieldType == long.class) {
                        predicates.add(cb.equal(root.get(field), Long.parseLong(value)));
                    }

                    else if (field.endsWith("Min") && (fieldType == Double.class || fieldType == double.class)) {
                        String baseField = field.substring(0, field.length() - 3);
                        predicates.add(cb.greaterThanOrEqualTo(root.get(baseField), Double.parseDouble(value)));
                    }
                    else if (field.endsWith("Max") && (fieldType == Double.class || fieldType == double.class)) {
                        String baseField = field.substring(0, field.length() - 3);
                        predicates.add(cb.lessThanOrEqualTo(root.get(baseField), Double.parseDouble(value)));
                    }

                    else if (fieldType == Double.class || fieldType == double.class) {
                        predicates.add(cb.equal(root.get(field), Double.parseDouble(value)));
                    }

                    else if (fieldType == OffsetDateTime.class || fieldType == LocalDateTime.class
                            || fieldType == Date.class || fieldType == LocalDate.class) {
                        OffsetDateTime parsedDate = parseDateWithTimeZone(value, argentinaZone);
                        if (parsedDate != null) {
                            predicates.add(cb.equal(root.get(field), parsedDate));
                        }
                    }

                } catch (NoSuchFieldException | IllegalArgumentException | DateTimeParseException e) {
                    System.err.println("Error processing filter " + field + ": " + e.getMessage());
                    throw new RuntimeException(e);
                }
            });
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private OffsetDateTime parseDateWithTimeZone(String value, ZoneId zoneId) {
        try {
            return OffsetDateTime.parse(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate localDate = LocalDate.parse(value);
                return localDate.atStartOfDay(zoneId).toOffsetDateTime();
            } catch (DateTimeParseException ex) {
                return null;
            }
        }
    }
}
