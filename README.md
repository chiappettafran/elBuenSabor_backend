
# 🔧 El Buen Sabor – Backend

Este repositorio contiene el código fuente del **Backend** del sistema de gestión para el restaurante _El Buen Sabor_, desarrollado como proyecto final de la materia **Laboratorio de Computación IV** (UTN – FRM – TUP).

La aplicación está diseñada con una arquitectura RESTful, asegurada mediante JWT y conectada a una base de datos PostgreSQL. Ofrece servicios para gestionar usuarios, pedidos, cocina, facturación, delivery, inventario y reportes.

---

## 🧑‍💻 Integrantes

- Ignacio Audero
- Aarón Kibysz
- Francisco Martínez Chiappetta

---

## ⚙️ Tecnologías

- **Java 17**
- **Spring Boot 3+**
- **Spring Security con JWT**
- **JPA / Hibernate**
- **PostgreSQL**
- **Gradle**
- **REST API**
- **Google OAuth 2.0**
- **MailJS** – Envío de correos electrónicos
- **Mercado Pago** – Integración de pagos

---


## 🔐 Seguridad

- Autenticación con JWT
- Login social con Google OAuth 2.0
- Roles y permisos: `ADMIN`, `CLIENTE`, `COCINERO`, `CAJERO`, `DELIVERY`
- Protección de rutas según perfil
- Encriptación de contraseñas con BCrypt

---
## 🔧 Configuración

Modificar `src/main/resources/application.properties` con los datos de conexión:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/elbuensabor
spring.datasource.username=postgres
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
```

---

