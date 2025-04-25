package org.internalPointerVariable.elbuensabor_backend.services.base;

import org.internalPointerVariable.elbuensabor_backend.dtos.ImageHolderDto;
import org.internalPointerVariable.elbuensabor_backend.exceptions.ImageProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseService<ENTITY, RESPONSE_DTO, REQUEST_DTO> {

    private final JpaRepository<ENTITY, Long> entityRepository;
    public BaseService(JpaRepository<ENTITY, Long> entityRepository) {
        this.entityRepository = entityRepository;
    }
    private final String UPLOAD_DIR = "uploads/";
    protected final ModelMapper modelMapper = new ModelMapper();


    @Transactional(readOnly = true)
    public List<RESPONSE_DTO> getAll(Class<RESPONSE_DTO> dtoClass) {
        return entityRepository.findAll().stream()
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
    public ENTITY save(REQUEST_DTO dto, Class<ENTITY> entityClass) {
        ENTITY entity = modelMapper.map(dto, entityClass);

        if (dto instanceof ImageHolderDto imageHolderDto && imageHolderDto.getImagenFile() != null && !imageHolderDto.getImagenFile().isEmpty()) {
            String imagen = saveImage(imageHolderDto.getImagenFile());
            imageHolderDto.setImagen(imagen);
            entity = modelMapper.map(dto, entityClass);
        }

        processEntityRelationshipsWrite(entity, dto);
        return entityRepository.save(entity);
    }

    @Transactional
    public ENTITY update(Long id, REQUEST_DTO dto, Class<ENTITY> entityClass) {
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
        processEntityRelationshipsWrite(updated, dto);
        BeanUtils.copyProperties(updated, existing, "id");

        return entityRepository.save(existing);
    }

    @Transactional
    public boolean delete(Long id) {
        if (!entityRepository.existsById(id)) {
            throw new NoSuchElementException("Entidad con ID " + id + " no encontrada");
        }
        entityRepository.deleteById(id);
        return true;
    }

    protected void processEntityRelationshipsWrite(ENTITY entity, REQUEST_DTO dto) {
    }

    protected RESPONSE_DTO processEntityRelationshipsRead(ENTITY entity, RESPONSE_DTO dto) {
        return dto;
    }


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


}
