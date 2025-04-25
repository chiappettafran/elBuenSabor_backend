package org.internalPointerVariable.elbuensabor_backend.dtos;

import org.springframework.web.multipart.MultipartFile;

public interface ImageHolderDto {
    MultipartFile getImagenFile();
    String getImagen();
    void setImagen(String imagen);
}
