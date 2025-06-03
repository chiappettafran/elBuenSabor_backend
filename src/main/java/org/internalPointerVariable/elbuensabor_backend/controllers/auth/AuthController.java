package org.internalPointerVariable.elbuensabor_backend.controllers.auth;

import org.internalPointerVariable.elbuensabor_backend.entities.PersonaCliente;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sync")
    public ResponseEntity<Map<String, Object>> syncUser(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Jwt jwt = (Jwt) authentication.getPrincipal();

        try {
            String auth0Id = jwt.getSubject();
            String email = jwt.getClaimAsString("email");
            String name = jwt.getClaimAsString("name");

            String tipoUsuario = authService.determinarTipoUsuario(auth0Id);

            Map<String, Object> response = new HashMap<>();

            if ("CLIENTE".equals(tipoUsuario)) {
                PersonaCliente cliente = authService.syncCliente(auth0Id, email, name);
                response.put("id", cliente.getId());
                response.put("nombre", cliente.getNombre());
                response.put("apellido", cliente.getApellido());
                response.put("email", cliente.getEmail());
                response.put("rol", cliente.getRol().toString());
                response.put("tipo", "CLIENTE");

            } else if ("EMPLEADO".equals(tipoUsuario)) {
                PersonaEmpleado empleado = authService.syncEmpleado(auth0Id, email);
                response.put("id", empleado.getId());
                response.put("nombre", empleado.getNombre());
                response.put("apellido", empleado.getApellido());
                response.put("rol", empleado.getRol().toString());
                response.put("puesto", empleado.getPuesto());
                response.put("tipo", "EMPLEADO");
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
