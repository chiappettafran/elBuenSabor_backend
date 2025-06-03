package org.internalPointerVariable.elbuensabor_backend.services.auth;

import org.internalPointerVariable.elbuensabor_backend.entities.PersonaCliente;
import org.internalPointerVariable.elbuensabor_backend.entities.PersonaEmpleado;
import org.internalPointerVariable.elbuensabor_backend.entities.enumClasses.RolEnum;
import org.internalPointerVariable.elbuensabor_backend.repositories.PersonaClienteRepository;
import org.internalPointerVariable.elbuensabor_backend.repositories.PersonaEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthService {
    @Autowired
    private PersonaClienteRepository clienteRepository;

    @Autowired
    private PersonaEmpleadoRepository empleadoRepository;

    public PersonaCliente syncCliente(String auth0Id, String email, String name) {
        // Buscar cliente existente por auth0Id
        Optional<PersonaCliente> existing = clienteRepository.findByAuth2Id(auth0Id);

        if (existing.isPresent()) {
            return existing.get();
        }

        // Verificar que es login con Google
        if (!auth0Id.startsWith("google-oauth2|")) {
            throw new RuntimeException("Los clientes solo pueden usar Google para iniciar sesión");
        }

        // Crear nuevo cliente
        PersonaCliente cliente = new PersonaCliente();
        cliente.setAuth2Id(auth0Id);
        cliente.setEmail(email);
        cliente.setRol(RolEnum.CLIENTE);

        // Separar nombre y apellido
        String[] nameParts = name.split(" ", 2);
        cliente.setNombre(nameParts[0]);
        cliente.setApellido(nameParts.length > 1 ? nameParts[1] : "");

        return clienteRepository.save(cliente);
    }

    public PersonaEmpleado syncEmpleado(String auth0Id, String email) {
        // Verificar que es login de base de datos
        if (!auth0Id.startsWith("auth0|")) {
            throw new RuntimeException("Los empleados solo pueden usar usuario y contraseña");
        }

        // Buscar empleado existente por auth0Id
        Optional<PersonaEmpleado> existing = empleadoRepository.findByAuth2Id(auth0Id);

        if (existing.isPresent()) {
            return existing.get();
        }

        // Buscar empleado existente por email para actualizar auth0Id
        Optional<PersonaEmpleado> empleadoPorEmail = empleadoRepository.findByEmail(email);

        if (empleadoPorEmail.isPresent()) {
            PersonaEmpleado empleado = empleadoPorEmail.get();
            empleado.setAuth2Id(auth0Id);
            return empleadoRepository.save(empleado);
        }

        throw new RuntimeException("Empleado no encontrado. Contacte al administrador.");
    }

    public String determinarTipoUsuario(String auth0Id) {
        if (auth0Id.startsWith("google-oauth2|")) {
            return "CLIENTE";
        } else if (auth0Id.startsWith("auth0|")) {
            return "EMPLEADO";
        }
        throw new RuntimeException("Tipo de usuario no válido");
    }
}
