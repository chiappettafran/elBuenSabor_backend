package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.UsuarioDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Usuario;
import org.internalPointerVariable.elbuensabor_backend.repositories.UsuarioRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioDtos.ResponseDTO, UsuarioDtos.RequestDTO> {

    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
