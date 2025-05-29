package org.internalPointerVariable.elbuensabor_backend.controllers.imagenes;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("imagenes")
public class ImagenController {

    @GetMapping("/{nombreImagen}")
    public ResponseEntity<Resource> obtenerImagen(@PathVariable String nombreImagen) {
        try {
            String UPLOAD_DIR = "uploads/";
            Path rutaArchivo = Paths.get(UPLOAD_DIR).resolve(nombreImagen).normalize();
            Resource recurso = new UrlResource(rutaArchivo.toUri());

            if (recurso.exists()) {
                String contentType = Files.probeContentType(rutaArchivo);
                if (contentType == null) {
                    contentType = "application/octet-stream"; // fallback
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + recurso.getFilename() + "\"")
                        .body(recurso);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
