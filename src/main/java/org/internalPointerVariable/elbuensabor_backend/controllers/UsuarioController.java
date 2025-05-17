package org.internalPointerVariable.elbuensabor_backend.controllers;

import org.internalPointerVariable.elbuensabor_backend.controllers.base.BaseController;
import org.internalPointerVariable.elbuensabor_backend.dtos.UsuarioDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Usuario;
import org.internalPointerVariable.elbuensabor_backend.services.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioDtos.ResponseDTO, UsuarioDtos.RequestDTO> {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        super(service);
        this.service = service;
    }

    @Override
    protected Class<Usuario> getEntityClass() {
        return Usuario.class;
    }

    @Override
    protected Class<UsuarioDtos.ResponseDTO> getDTOClass() {
        return UsuarioDtos.ResponseDTO.class;
    }
}
